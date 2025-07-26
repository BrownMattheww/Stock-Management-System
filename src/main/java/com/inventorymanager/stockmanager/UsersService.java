package com.inventorymanager.stockmanager;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private final UserRepository userRepository;

    @Autowired
    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Users> findAll() {
        return userRepository.findAll();
    }

    public Users findById(@PathVariable Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public Optional<Users> findByUsername(@NotNull String username) {
        if (username.trim().isEmpty()) {
            return Optional.empty();
        }
        return userRepository.findByUsername(username);
    }

    public Users createUser(@NotNull Users user) {
        return userRepository.save(user);
    }

    public Users updateUser(@NotNull Users user) {
        return userRepository.save(user);
    }

    public void deleteUser(@NotNull Integer id) {
        Users user = userRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new UsernameNotFoundException("User with id " + id + " not found!"));
        userRepository.delete(user);
    }
}
