package com.inventorymanager.stockmanager.location;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import com.inventorymanager.stockmanager.stockLocation.StockLocation;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Location {
    @Id
    @Column(name = "location_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;

    @NotBlank
    private String aisle;

    @NotBlank
    private String shelf;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<StockLocation> stockLocations = new HashSet<>();

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
