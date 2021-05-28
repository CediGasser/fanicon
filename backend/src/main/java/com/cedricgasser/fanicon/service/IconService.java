package com.cedricgasser.fanicon.service;

import com.cedricgasser.fanicon.dto.IconDto;
import com.cedricgasser.fanicon.model.Icon;
import com.cedricgasser.fanicon.repository.IconRepository;
import com.cedricgasser.fanicon.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class IconService {

    private final IconRepository iconRepository;
    private final ThemeRepository themeRepository;

    @Autowired
    public IconService(IconRepository iconRepository, ThemeRepository themeRepository) {
        this.iconRepository = iconRepository;
        this.themeRepository = themeRepository;
    }

    @Transactional
    public Icon add(final IconDto iconDto) {
        Icon icon = new Icon();
        icon.setName(iconDto.getName());
        icon.setSvg(iconDto.getSvg());
        icon.setStyle(iconDto.getStyle());
        icon.setCopyrighted(iconDto.getCopyrighted());
        icon.setCopyrightSource(iconDto.getCopyrightSource());
        icon.setTheme(themeRepository.findById(iconDto.getThemeId()).orElseThrow());
        return iconRepository.save(icon);
    }

    @Transactional
    public void delete(final long id) {
        iconRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Icon> getById(final long id) {
        return iconRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Icon> searchByNameOrThemeName(final String q) {
        return iconRepository.searchByNameOrThemeName(q);
    }

    @Transactional(readOnly = true)
    public List<Icon> getAll() {
        Iterable<Icon> icons = iconRepository.findAll();
        return StreamSupport
                .stream(icons.spliterator(), false)
                .collect(Collectors.toList());
    }
}
