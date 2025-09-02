package com.inventorymanager.stockmanager.stock;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.inventorymanager.stockmanager.location.Location;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import com.inventorymanager.stockmanager.stockLocation.StockLocation;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockId;

    @NotEmpty
    private String stockName;

    @NotNull
    private BigDecimal stockPrice;

    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<StockLocation> stockLocations = new HashSet<>();

    public Stock() {
    }

    public Stock(String stockName, BigDecimal stockPrice) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
    }

    public void addStockLocation(Location location, int quantity) {
        StockLocation stockLocation = new StockLocation(this, location, quantity);
        this.stockLocations.add(stockLocation);
    }

    public Long getStockId() {
        return stockId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public BigDecimal getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(BigDecimal stockPrice) {
        this.stockPrice = stockPrice;
    }

    public Long getId() {
        return stockId;
    }

    public Set<StockLocation> getStockLocations() {
        return stockLocations;
    }
}
