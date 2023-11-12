package com.springboot.springbootusertodo.repository;

import com.springboot.springbootusertodo.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer> {

    @Query("SELECT u FROM AppUser u WHERE u.username = :username and u.password = :password")
    AppUser findUser(@Param("username") String username, @Param("password") String password);
}
