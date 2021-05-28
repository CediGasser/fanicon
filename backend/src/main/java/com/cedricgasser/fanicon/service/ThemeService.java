package com.cedricgasser.fanicon.service;

import com.cedricgasser.fanicon.model.Icon;
import com.cedricgasser.fanicon.model.Theme;
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
public class ThemeService {

    private final ThemeRepository themeRepository;
    private final IconRepository iconRepository;

    @Autowired
    public ThemeService(ThemeRepository themeRepository, IconRepository iconRepository) {
        this.themeRepository = themeRepository;
        this.iconRepository = iconRepository;
    }

    @Transactional
    public Theme add(final Theme theme) {
        return themeRepository.save(theme);
    }

    @Transactional
    public void delete(final long id) {
        themeRepository.deleteById(id);
    }

    @Transactional
    public Optional<Theme> getById(final long id) {
        return themeRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Icon> getIconsFromTheme(final long id) {
        return iconRepository.findByTheme(id);
    }

    @Transactional(readOnly = true)
    public List<Theme> searchByName(final String name) {
        return themeRepository.searchByName(name);
    }

    @Transactional
    public List<Theme> getAll(){
        Iterable<Theme> themes = themeRepository.findAll();
        return StreamSupport
                .stream(themes.spliterator(), false)
                .collect(Collectors.toList());
    }
}
