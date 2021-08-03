package com.cedricgasser.fanicon.repository;

import com.cedricgasser.fanicon.model.User;
import com.cedricgasser.fanicon.model.UserGroup;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface UserRepository extends CrudRepository<User, String> {
    User checkPassword(String name, String password);
    User getByName(String name);

    @Transactional
    @Modifying
    @Query("UPDATE User SET user_group = :#{#userGroup.toString()} WHERE name =:#{#name}")
    void changeUserGroup(@Param("name") String name, @Param("userGroup") UserGroup userGroup);
}
