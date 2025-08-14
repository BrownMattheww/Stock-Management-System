package com.inventorymanager.stockmanager.stockLocation;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StockLocationId implements Serializable {
    private Long stockId;
    private Long locationId;

    public StockLocationId() {}

    public StockLocationId(Long stockId, Long locationId) {
        this.stockId = stockId;
        this.locationId = locationId;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StockLocationId that = (StockLocationId) o;
        return Objects.equals(stockId, that.stockId) && Objects.equals(locationId, that.locationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockId, locationId);
    }
}
