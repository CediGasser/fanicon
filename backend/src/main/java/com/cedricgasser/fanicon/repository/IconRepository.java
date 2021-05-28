package com.cedricgasser.fanicon.repository;

import com.cedricgasser.fanicon.model.Icon;
import com.cedricgasser.fanicon.model.IconInDesign;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IconRepository extends CrudRepository<Icon, Long> {
    public List<Icon> findByTheme(long id);
    public List<Icon> searchByNameOrThemeName(String name, String theme_name);
    public Optional<Icon> findByIconInDesign(IconInDesign iconInDesign);
}
