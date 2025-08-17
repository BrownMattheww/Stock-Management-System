package com.inventorymanager.stockmanager.stock;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import com.inventorymanager.stockmanager.stockLocation.StockLocation;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long stockId;

    @NotEmpty
    private String stockName;

    @NotEmpty
    private BigDecimal stockPrice;

    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL)
    private Set<StockLocation> stockLocations = new HashSet<>();

    public Stock() {
    }

    public Stock(String stockName, BigDecimal stockPrice) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
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
}
