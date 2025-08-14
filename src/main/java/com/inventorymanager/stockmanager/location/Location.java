package com.inventorymanager.stockmanager.location;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long locationId;

    @NotBlank
    private String aisle;

    @NotBlank
    private String shelf;

    public Location() {
    }

    public Location(String aisle, String shelf) {
        this.aisle = aisle;
        this.shelf = shelf;
    }

    public Long getLocationId() {
        return locationId;
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

    public Long getId() {
        return locationId;
    }
}
