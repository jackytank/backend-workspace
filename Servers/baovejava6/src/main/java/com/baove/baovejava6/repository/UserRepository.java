package com.baove.baovejava6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.baove.baovejava6.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{
    @Query("select u from User u where u.id like CONCAT('%',:query,'%') or u.fullname like CONCAT('%',:query,'%')")
    List<User> searchUser(@Param("query") String query);
}
