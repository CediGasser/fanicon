package com.cedricgasser.fanicon.service;

import com.cedricgasser.fanicon.model.Icon;
import com.cedricgasser.fanicon.repository.IconRepository;
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

    @Autowired
    public IconService(IconRepository iconRepository) {
        this.iconRepository = iconRepository;
    }

    @Transactional
    public Icon add(final Icon icon) {
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
    public List<Icon> searchByNameOrThemeName(final String name, final String themeName) {
        return iconRepository.searchByNameOrThemeName(name, themeName);
    }

    @Transactional(readOnly = true)
    public List<Icon> getAll() {
        Iterable<Icon> icons = iconRepository.findAll();
        return StreamSupport
                .stream(icons.spliterator(), false)
                .collect(Collectors.toList());
    }
}
