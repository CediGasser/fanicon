package com.cedricgasser.fanicon.service;

import com.cedricgasser.fanicon.dto.IconInDesignDto;
import com.cedricgasser.fanicon.model.Design;
import com.cedricgasser.fanicon.model.Icon;
import com.cedricgasser.fanicon.model.IconInDesign;
import com.cedricgasser.fanicon.repository.DesignRepository;
import com.cedricgasser.fanicon.repository.IconInDesignRepository;
import com.cedricgasser.fanicon.repository.IconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DesignService {

    private final DesignRepository designRepository;
    private final IconInDesignRepository iconInDesignRepository;
    private final IconRepository iconRepository;

    @Autowired
    public DesignService(DesignRepository designRepository, IconInDesignRepository iconInDesignRepository, IconRepository iconRepository) {
        this.designRepository = designRepository;
        this.iconInDesignRepository = iconInDesignRepository;
        this.iconRepository = iconRepository;
    }

    @Transactional
    public Design add(final Design design) {
        return designRepository.save(design);
    }

    @Transactional
    public void delete(final long id) {
        designRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Design> getById(final long id) {
        return designRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<IconInDesignDto> getIconsFromDesignId(final long id) {
        final List<IconInDesign> iconsInDesign = iconInDesignRepository.getIconInDesignsByDesign(getById(id).orElseThrow());
        List<IconInDesignDto> icons = null;
        for (IconInDesign designIcon: iconsInDesign) {
            Icon icon = iconRepository.findByIconInDesign(designIcon).orElseThrow();
            icons.add(new IconInDesignDto(icon.getName(), icon.getSvg(), icon.getTheme(), icon.getStyle(), icon.getCopyrighted(), icon.getCopyrightSource() ,designIcon.position));
        }
        return icons;
    }
}
