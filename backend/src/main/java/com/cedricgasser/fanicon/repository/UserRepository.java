package com.cedricgasser.fanicon.repository;

import com.cedricgasser.fanicon.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    User checkPassword(String name, String password);
    User getByName(String name);
}
