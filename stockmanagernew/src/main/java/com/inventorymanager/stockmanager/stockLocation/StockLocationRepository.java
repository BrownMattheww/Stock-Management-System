package com.inventorymanager.stockmanager.stockLocation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockLocationRepository extends JpaRepository<StockLocation, StockLocationId> {
    @Query("SELECT new com.inventorymanager.stockmanager.stockLocation.StockLocationDTO(" +
            "sl.stock.stockName, sl.location.aisle, sl.location.shelf, sl.quantity) " +
            "FROM StockLocation sl")
    List<StockLocationDTO> findAllStockLocationDetails();
}
