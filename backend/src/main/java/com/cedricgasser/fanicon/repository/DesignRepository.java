package com.cedricgasser.fanicon.repository;

import com.cedricgasser.fanicon.model.Design;
import com.cedricgasser.fanicon.model.IconInDesign;
import com.cedricgasser.fanicon.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DesignRepository extends CrudRepository<Design, Long> {
    public List<Design> getAllByUser(final User user);
    public Design getByNameAndUser(final String name, final User user);
}
