package com.cedricgasser.fanicon.repository;

import com.cedricgasser.fanicon.model.Icon;
import org.springframework.data.repository.CrudRepository;

public interface IconRepository extends CrudRepository<Icon, Long> {
}
