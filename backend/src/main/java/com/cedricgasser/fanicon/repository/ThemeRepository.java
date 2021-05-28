package com.cedricgasser.fanicon.repository;

import com.cedricgasser.fanicon.model.Theme;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ThemeRepository extends CrudRepository<Theme, Long> {
    List<Theme> searchByName(final String name);
}
