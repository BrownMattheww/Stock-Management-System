package com.inventorymanager.stockmanager.stockLocation;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping("/stockLocation")
@RestController
public class StockLocationController {
    final StockLocationService stockLocationService;

    public StockLocationController(StockLocationService stockLocationService) {
        this.stockLocationService = stockLocationService;
    }

    @GetMapping("/stock-locations")
    public List<StockLocationDTO> findAllStockLocations() {
        try {
            return stockLocationService.findAllStockLocationDetails();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to fetch stock location details", e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockLocation> getStockLocationById(@PathVariable StockLocationId id) {
        try {
            StockLocation stockLocation = stockLocationService.findById(id);
            return ResponseEntity.ok(stockLocation);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<StockLocation> addStockLocation(@RequestBody StockLocation stockLocation) {
        try {
            StockLocation newStockLocation = stockLocationService.createStockLocation(stockLocation);
            return ResponseEntity.ok(newStockLocation);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockLocation> updateStockLocation(@PathVariable StockLocationId id, @RequestBody StockLocation stockLocation) {
        try {
            StockLocation emmendedStockLocation = stockLocationService.findById(id);
            return ResponseEntity.ok(emmendedStockLocation);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStockLocationById(@PathVariable StockLocationId id) {
        stockLocationService.removeStockLocation(id);
        return ResponseEntity.noContent().build();
    }
}
