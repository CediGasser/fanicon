package com.cedricgasser.fanicon.controller;

import com.cedricgasser.fanicon.dto.IconDto;
import com.cedricgasser.fanicon.model.Icon;
import com.cedricgasser.fanicon.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/icons")
@PreAuthorize("hasAuthority('NORMAL') or hasAuthority('VIP') or hasAuthority('ADMIN')")
public class IconController {
    private final IconService iconService;

    @Autowired
    public IconController(IconService iconService) {
        this.iconService = iconService;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public Icon add(@RequestBody final IconDto icon) {
        return iconService.add(icon);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void delete(@PathVariable final Long id) {
        iconService.delete(id);
    }

    @GetMapping("/{id}")
    public Icon getById(@PathVariable final Long id) { return iconService.getById(id).orElseThrow(); }

    @GetMapping
    public List<Icon> get(@RequestParam(required = false) String q) {
        if (q != null) {
            return iconService.searchByNameOrThemeName(q);
        }
        return iconService.getAll();
    }
}
