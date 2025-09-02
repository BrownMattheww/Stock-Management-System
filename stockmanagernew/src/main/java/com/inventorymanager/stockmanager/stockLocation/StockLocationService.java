package com.inventorymanager.stockmanager.stockLocation;

import com.inventorymanager.stockmanager.location.Location;
import com.inventorymanager.stockmanager.location.LocationRepository;
import com.inventorymanager.stockmanager.stock.Stock;
import com.inventorymanager.stockmanager.stock.StockRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StockLocationService {
    private final StockLocationRepository StockLocationRepository;
    private final LocationRepository locationRepository;
    private final StockRepository stockRepository;

    @Autowired
    public StockLocationService(StockLocationRepository stockLocationRepository, LocationRepository locationRepository,  StockRepository stockRepository) {
        StockLocationRepository = stockLocationRepository;
        this.locationRepository = locationRepository;
        this.stockRepository = stockRepository;
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
        if (!updatedStockLocation.isPresent()) {
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

    public List<StockLocationDTO> findAllStockLocationDetails() {
        List<StockLocationDTO> stockLocationResults = StockLocationRepository.findAllStockLocationDetails();
        if (stockLocationResults.isEmpty()) {
            return Collections.emptyList();
        }
        return stockLocationResults;
    }

    public Stock createStockWithLocation(StockLocationDTO dto) {
        Location location = locationRepository.findByAisleAndShelf(dto.getAisle(), dto.getShelf())
                .orElseGet(() -> {
                    Location newLocation = new Location();
                    newLocation.setAisle(dto.getAisle());
                    newLocation.setShelf(dto.getShelf());
                    return locationRepository.save(newLocation);
                });

        Stock stock = new Stock(dto.getStockName(), dto.getStockPrice());

        stock.addStockLocation(location, dto.getQuantity());

        return stockRepository.save(stock);
    }
}
