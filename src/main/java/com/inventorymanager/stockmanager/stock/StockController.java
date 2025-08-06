package com.inventorymanager.stockmanager.stock;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/stock")
@RestController
public class StockController {
    public final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public List<Stock> getAllStocks() {
        return stockService.findAll();
    }

    @PostMapping
    public ResponseEntity<Stock> createStock(@RequestBody @Valid Stock stock) {
        try {
            Stock createdStock = new Stock();
            return ResponseEntity.status(HttpStatus.CREATED).body(createdStock);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity<Stock> updateStock(@RequestBody @Valid Stock stock) {
        try{
            Stock updatedStock = new Stock();
            return ResponseEntity.status(HttpStatus.OK).body(updatedStock);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStock(@PathVariable("id") Long stockId) {
        try {
            Stock deletedStock = stockService.deleteStock(stockId);
            return ResponseEntity.ok("Stock deleted successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
