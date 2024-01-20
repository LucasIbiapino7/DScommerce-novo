package com.devsuperior.DScommercenovo.services;

import com.devsuperior.DScommercenovo.entities.User;
import com.devsuperior.DScommercenovo.services.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService service;

    public void validateSelfOrAdmin(Long userId){
        User user = service.authenticated();
        if (!user.hasRole("ROLE_ADMIN") && !user.getId().equals(userId)){
            throw new ForbiddenException("Acess Denied");
        }
    }
}
