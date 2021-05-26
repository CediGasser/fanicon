package com.cedricgasser.fanicon.repository;

import com.cedricgasser.fanicon.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User checkPassword(String name, String password);
}
