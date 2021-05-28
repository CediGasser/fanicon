package com.cedricgasser.fanicon.repository;

import com.cedricgasser.fanicon.model.Icon;
import com.cedricgasser.fanicon.model.IconInDesign;
import com.cedricgasser.fanicon.model.Theme;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IconRepository extends CrudRepository<Icon, Long> {
    public List<Icon> findByTheme(Theme theme);
    public List<Icon> searchByNameOrThemeName(String q);
    public Optional<Icon> findByIconInDesign(IconInDesign iconInDesign);
}
