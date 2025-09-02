package com.inventorymanager.stockmanager.stockLocation;

import com.inventorymanager.stockmanager.stock.Stock;
import com.inventorymanager.stockmanager.stock.StockService;
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
    final StockService stockService;

    public StockLocationController(StockLocationService stockLocationService, StockService stockService) {
        this.stockLocationService = stockLocationService;
        this.stockService = stockService;
    }

    @GetMapping
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

    @PostMapping("/stock-with-location")
    public ResponseEntity<StockLocationDTO> createStock(@RequestBody StockLocationDTO dto) {
        Stock createdStock = stockLocationService.createStockWithLocation(dto);

        StockLocation location = createdStock.getStockLocations().stream().findFirst().orElse(null);

        StockLocationDTO responseDto = new StockLocationDTO(
                createdStock.getStockName(),
                location != null ? location.getLocation().getAisle() : null,
                location != null ? location.getLocation().getShelf() : null,
                location != null ? location.getQuantity() : 0
        );

        responseDto.setStockPrice(createdStock.getStockPrice());

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
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
