package com.example.ProjetPriseMain.repository;

import com.example.ProjetPriseMain.entities.AppUser;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<AppUser, Long> {
    public AppUser findByUsername(String username);
}
