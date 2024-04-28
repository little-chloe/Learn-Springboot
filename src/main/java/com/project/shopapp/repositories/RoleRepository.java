package com.project.shopapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.shopapp.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
}
