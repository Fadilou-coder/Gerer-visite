package com.example.ProjetPriseMain.repository;

import com.example.ProjetPriseMain.entities.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
    public Role findByRoleName(String role);
}
