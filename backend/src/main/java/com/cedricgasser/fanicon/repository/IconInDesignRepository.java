package com.cedricgasser.fanicon.repository;

import com.cedricgasser.fanicon.model.Design;
import com.cedricgasser.fanicon.model.IconInDesign;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IconInDesignRepository extends CrudRepository<IconInDesign, Long> {
    public List<IconInDesign> getIconInDesignsByDesign(final Design design);
}
