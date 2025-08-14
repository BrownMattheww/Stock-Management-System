package com.inventorymanager.stockmanager.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController
public class LocationController {
    private final LocationRepository locationRepository;
    private final LocationService locationService;

    @Autowired
    public LocationController(LocationRepository locationRepository, LocationService locationService) {
        this.locationRepository = locationRepository;
        this.locationService = locationService;
    }

    @GetMapping
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    @GetMapping("/{locationId}")
    public ResponseEntity<Location> findById(@PathVariable Long locationId) {
        return locationRepository.findById(locationId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Location> createLocation(@RequestBody Location location) {
        try {
            Location newLocation = locationService.createLocation(location);
            return ResponseEntity.status(HttpStatus.CREATED).body(newLocation);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{locationId}")
    public ResponseEntity<Location> updateLocation(@PathVariable Long locationId, @RequestBody Location location) {
        try{
            Location ammendedLocation = locationService.updateLocation(locationId,  location);
            return ResponseEntity.status(HttpStatus.OK).body(ammendedLocation);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{locationId}")
    public ResponseEntity<Void> deleteLocation(@PathVariable("locationId") Long locationId) {
        locationService.deleteLocation(locationId);
        return ResponseEntity.noContent().build();
    }
}

