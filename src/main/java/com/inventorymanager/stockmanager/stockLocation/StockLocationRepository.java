package com.inventorymanager.stockmanager.stockLocation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockLocationRepository extends JpaRepository<StockLocation, StockLocationId> {
}
