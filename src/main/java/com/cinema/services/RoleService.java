package com.cinema.services;

import com.cinema.models.Role;
import com.cinema.repositories.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RoleService extends AbstractService<Role, UUID>{

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    protected JpaRepository<Role, UUID> getRepository() {
        return roleRepository;
    }

    public Role getRoleByName(String s) {
        return roleRepository.getRoleByRole(s);
    };
}
