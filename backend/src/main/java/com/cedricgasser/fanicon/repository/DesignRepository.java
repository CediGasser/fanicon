package com.cedricgasser.fanicon.repository;

import com.cedricgasser.fanicon.model.Design;
import com.cedricgasser.fanicon.model.IconInDesign;
import org.springframework.data.repository.CrudRepository;

public interface DesignRepository extends CrudRepository<Design, Long> {
}
