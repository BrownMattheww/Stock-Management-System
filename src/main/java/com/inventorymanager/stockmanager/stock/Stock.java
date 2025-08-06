package com.inventorymanager.stockmanager.stock;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long stockId;

    @NotEmpty
    private String stockName;

    @NotEmpty
    private BigDecimal stockPrice;

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
}
