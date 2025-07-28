package com.inventorymanager.stockmanager;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long stock_id;

    private String stock_name;

    private BigDecimal stock_price;

    public Stock() {
    }

    public Stock(String stock_name, BigDecimal stock_price) {
        this.stock_name = stock_name;
        this.stock_price = stock_price;
    }

    //Getters and setters
    public long getStock_id() {
        return stock_id;
    }

    public String getStock_name() {
        return stock_name;
    }

    public void setStock_name(String stock_name) {
        this.stock_name = stock_name;
    }

    public BigDecimal getStock_price() {
        return stock_price;
    }

    public void setStock_price(BigDecimal stock_price) {
        this.stock_price = stock_price;
    }
}
