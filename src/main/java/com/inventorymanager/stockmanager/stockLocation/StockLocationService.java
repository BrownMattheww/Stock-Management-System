package com.inventorymanager.stockmanager.stockLocation;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockLocationService {
    private final StockLocationRepository StockLocationRepository;

    @Autowired
    public StockLocationService(StockLocationRepository stockLocationRepository) {
        StockLocationRepository = stockLocationRepository;
    }

    public List<StockLocation> findAll() {
        return StockLocationRepository.findAll();
    }

    public StockLocation findById(StockLocationId id) {
        return StockLocationRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User with id " + id + " not found!"));
    }

    public StockLocation createStockLocation(StockLocation stockLocation) {
        StockLocation newStockLocation = new StockLocation();
        newStockLocation.setLocation(stockLocation.getLocation());
        newStockLocation.setStock(stockLocation.getStock());
        newStockLocation.setQuantity(stockLocation.getQuantity());
        return StockLocationRepository.save(newStockLocation);
    }

    public StockLocation updateStockLocation(StockLocation stockLocation, StockLocationId id) {
        Optional<StockLocation> updatedStockLocation = StockLocationRepository.findById(id);
                if(!updatedStockLocation.isPresent()){
                    throw new EntityNotFoundException("StockLocation with id " + id + " not found!");
                }

                updatedStockLocation.get().setLocation(stockLocation.getLocation());
                updatedStockLocation.get().setStock(stockLocation.getStock());
                updatedStockLocation.get().setQuantity(stockLocation.getQuantity());
                return StockLocationRepository.save(updatedStockLocation.get());
    }

    public void removeStockLocation(StockLocationId id) {
        StockLocation stockLocation = StockLocationRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Stock Location with id " + id + " not found!"));

        StockLocationRepository.delete(stockLocation);
    }
}
