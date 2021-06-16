package com.cedricgasser.fanicon.controller;

import com.cedricgasser.fanicon.model.Icon;
import com.cedricgasser.fanicon.model.Theme;
import com.cedricgasser.fanicon.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/themes")
@PreAuthorize("hasAuthority('NORMAL') or hasAuthority('VIP') or hasAuthority('ADMIN')")
public class ThemeController {
    private final ThemeService themeService;

    @Autowired
    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public Theme add(@RequestBody final Theme theme) {
        return themeService.add(theme);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void delete(@PathVariable final Long id) {
        themeService.delete(id);
    }

    @GetMapping("/{id}")
    public Theme getById(@PathVariable final Long id) { return themeService.getById(id).orElseThrow(); }

    @GetMapping
    public List<Theme> get(@RequestParam(required = false) String name) {
        if (name != null) {
            return themeService.searchByName(name);
        }
        return themeService.getAll();
    }

    @GetMapping("/{id}/icons")
    public List<Icon> getIconsFromTheme(@PathVariable final Long id) { return themeService.getIconsFromTheme(id); }
}
