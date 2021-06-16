package com.cedricgasser.fanicon.controller;

import com.cedricgasser.fanicon.dto.DesignDto;
import com.cedricgasser.fanicon.dto.IconInDesignDto;
import com.cedricgasser.fanicon.model.Design;
import com.cedricgasser.fanicon.service.DesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/designs")
@PreAuthorize("hasAuthority('NORMAL') or hasAuthority('VIP') or hasAuthority('ADMIN')")
public class DesignController {
    private final DesignService designService;

    @Autowired
    public DesignController(DesignService designService) {
        this.designService = designService;
    }

    @GetMapping("/{id}/icons")
    public List<IconInDesignDto> getIconsFromDesign(@PathVariable final Long id){ return designService.getIconsFromDesignId(id); }

    @GetMapping
    public List<DesignDto> getAll(){ return designService.getAll(); }

    @GetMapping("/{id}")
    public DesignDto getById(@PathVariable final Long id){ return designService.getById(id); }

    @PostMapping("")
    public DesignDto add(@RequestBody final DesignDto designDto){ return designService.add(designDto); }
}
