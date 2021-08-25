package com.example.ProjetPriseMain.Service;

import com.example.ProjetPriseMain.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

@org.springframework.stereotype.Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private Service service;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = service.findUserByUsername(username);
        if (user == null) throw new UsernameNotFoundException(username);
        Collection<GrantedAuthority> authorities=new ArrayList<>();
        user.getRoles().forEach(appRole -> {
            authorities.add(new SimpleGrantedAuthority((appRole.getRoleName())));
        });

        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
