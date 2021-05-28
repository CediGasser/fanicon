package com.cedricgasser.fanicon.service;

import com.cedricgasser.fanicon.repository.DesignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DesignService {

    private final DesignRepository designRepository;

    @Autowired
    public DesignService(DesignRepository designRepository) {
        this.designRepository = designRepository;
    }
}
