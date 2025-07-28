package com.inventorymanager.stockmanager;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockInterface extends JpaRepository<Users, Long> {

}
