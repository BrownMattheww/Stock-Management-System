package com.inventorymanager.stockmanager.roles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleInterface extends JpaRepository<Role, Long> {
}
