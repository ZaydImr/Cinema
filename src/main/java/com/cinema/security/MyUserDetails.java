package com.cinema.security;

import com.cinema.models.Role;
import com.cinema.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import java.util.*;

public class MyUserDetails extends org.springframework.security.core.userdetails.User {

    private User user;

    public MyUserDetails(User user){
        super(user.getEmail(),user.getPassword(),getAuthorities(user));
        this.user = user;
    }
    public static Collection<? extends GrantedAuthority> getAuthorities(User user) {
        Set<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for(Role role : roles){
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return authorities;
    }
    public boolean hasRole(String roleName){
        return this.user.hasRole(roleName);
    }


    @Override
    public String getPassword() {
        return (user.getPassword());
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
