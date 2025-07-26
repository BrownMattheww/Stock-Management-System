package com.inventorymanager.stockmanager;

import jakarta.persistence.*;

@Entity
@Table(name = "users")

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String role;

    private String username;

    private String password;

    public Users() {
    }

    public Users(String role, String username, String password) {
        this.role = role;
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
