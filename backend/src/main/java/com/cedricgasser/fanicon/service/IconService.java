package com.cedricgasser.fanicon.service;

import com.cedricgasser.fanicon.repository.IconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IconService {

    private final IconRepository iconRepository;

    @Autowired
    public IconService(IconRepository iconRepository) {
        this.iconRepository = iconRepository;
    }
}
