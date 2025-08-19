package com.inventorymanager.stockmanager.users;

import com.inventorymanager.stockmanager.roles.Role;

import java.util.HashSet;
import java.util.Set;

public class UserDTO {
    private long userId;
    private String username;
    private Set<Role> roles = new HashSet<>();

    public UserDTO(long userId, String username, Set<Role> roles) {
        this.userId = userId;
        this.username = username;
        this.roles = roles;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
