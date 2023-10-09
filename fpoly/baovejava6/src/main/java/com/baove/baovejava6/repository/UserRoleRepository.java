package com.baove.baovejava6.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.baove.baovejava6.entity.User;
import com.baove.baovejava6.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    @Query("SELECT DISTINCT a FROM UserRole a WHERE a.user.id = ?1")
    List<UserRole> authoritiesOf(String id);

}
