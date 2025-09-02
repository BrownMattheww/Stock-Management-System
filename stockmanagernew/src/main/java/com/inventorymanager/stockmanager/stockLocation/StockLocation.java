package com.inventorymanager.stockmanager.stockLocation;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.inventorymanager.stockmanager.location.Location;
import com.inventorymanager.stockmanager.stock.Stock;
import jakarta.persistence.*;

@Entity
public class StockLocation {
    @EmbeddedId
    private StockLocationId id;

    @ManyToOne
    @MapsId("stockId")
    @JoinColumn(name = "stock_id")
    @JsonBackReference
    private Stock stock;

    @ManyToOne
    @MapsId("locationId")
    @JoinColumn(name = "location_id")
    private Location location;

    @Column(nullable = false)
    private int quantity;

    public StockLocation() {}

    public StockLocation(Stock stock, Location location, int quantity) {
        this.stock = stock;
        this.location = location;
        this.quantity = quantity;
        this.id = new StockLocationId(stock.getId(), location.getId());
    }

    public StockLocationId getId() {
        return id;
    }

    public void setId(StockLocationId id) {
        this.id = id;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
