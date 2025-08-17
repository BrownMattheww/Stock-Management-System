package com.inventorymanager.stockmanager.stockLocation;

public class StockLocationDTO {
    private String stockName;
    private String aisle;
    private String shelf;
    private int quantity;

    public StockLocationDTO(String stockName, String aisle, String shelf, int quantity) {
        this.stockName = stockName;
        this.aisle = aisle;
        this.shelf = shelf;
        this.quantity = quantity;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getAisle() {
        return aisle;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
