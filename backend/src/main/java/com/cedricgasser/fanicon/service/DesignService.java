package com.cedricgasser.fanicon.service;

import com.cedricgasser.fanicon.dto.DesignDto;
import com.cedricgasser.fanicon.dto.IconInDesignDto;
import com.cedricgasser.fanicon.model.Design;
import com.cedricgasser.fanicon.model.Icon;
import com.cedricgasser.fanicon.model.IconInDesign;
import com.cedricgasser.fanicon.repository.DesignRepository;
import com.cedricgasser.fanicon.repository.IconInDesignRepository;
import com.cedricgasser.fanicon.repository.IconRepository;
import com.cedricgasser.fanicon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DesignService {

    private final DesignRepository designRepository;
    private final IconInDesignRepository iconInDesignRepository;
    private final IconRepository iconRepository;
    private final UserRepository userRepository;

    @Autowired
    public DesignService(DesignRepository designRepository, IconInDesignRepository iconInDesignRepository, IconRepository iconRepository, UserRepository userRepository) {
        this.designRepository = designRepository;
        this.iconInDesignRepository = iconInDesignRepository;
        this.iconRepository = iconRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public DesignDto add(final DesignDto designDto) {
        final SecurityContext context = SecurityContextHolder.getContext();
        String userName = context.getAuthentication().getName();
        Design design = new Design(designDto.getName(), designDto.getBgColor(), designDto.getIconSize(), designDto.getIconMargin(), designDto.getIconColor(), userRepository.findById(userName).orElseThrow());
        Long designId = designRepository.save(design).getId();
        for (IconInDesignDto iconDto : designDto.getIcons()) {
            IconInDesign iconInDesign = new IconInDesign(designRepository.findById(designId).orElseThrow(),iconRepository.findById(iconDto.getIconId()).orElseThrow(), iconDto.getPosition());
            iconInDesignRepository.save(iconInDesign);
        }
        return getById(designId);
    }

    @Transactional
    public void delete(final long id) {
        designRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public DesignDto getById(final long id) {
        Design design = designRepository.findById(id).orElseThrow();
        List<IconInDesignDto> icons = new ArrayList();
        for (IconInDesign designIcon: iconInDesignRepository.getIconInDesignsByDesign(designRepository.findById(design.getId()).orElseThrow())) {
            icons.add(new IconInDesignDto(designIcon.getIcon().getId(), designIcon.getIcon().getName(), designIcon.getIcon().getSvg(), designIcon.getIcon().getTheme(), designIcon.getIcon().getStyle(), designIcon.getIcon().getCopyrighted(), designIcon.getIcon().getCopyrightSource(), designIcon.getPosition()));
        }

        return new DesignDto(design.getId(), design.getName(), design.getBgColor(), design.getIconSize(), design.getIconMargin(), design.getIconColor(), design.getUser().getName(), icons);
    }

    @Transactional(readOnly = true)
    public List<IconInDesignDto> getIconsFromDesignId(final Long id) {
        final List<IconInDesign> iconsInDesign = iconInDesignRepository.getIconInDesignsByDesign(designRepository.findById(id).orElseThrow());
        List<IconInDesignDto> icons = new ArrayList();
        for (IconInDesign designIcon: iconsInDesign) {
            Icon icon = iconRepository.findByIconInDesign(designIcon).orElseThrow();
            icons.add(new IconInDesignDto(designIcon.getIcon().getId(), icon.getName(), icon.getSvg(), icon.getTheme(), icon.getStyle(), icon.getCopyrighted(), icon.getCopyrightSource() ,designIcon.getPosition()));
        }
        return icons;
    }

    @Transactional(readOnly = true)
    public List<DesignDto> getAll(){
        Iterable<Design> designs = designRepository.findAll();
        List<Design> designList = StreamSupport
                .stream(designs.spliterator(), false)
                .collect(Collectors.toList());
        List<DesignDto> designDtos = new ArrayList();
        for (Design design: designList) {
            designDtos.add(new DesignDto(design.getId(), design.getName(), design.getBgColor(), design.getIconSize(), design.getIconMargin(), design.getIconColor(), design.getUser().getName(),getIconsFromDesignId(design.getId())));
        }
        return designDtos;
    }
}
