package com.inventorymanager.stockmanager.location;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    public Location findById(Long id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User with id " + id + " not found!"));
    }

    public Location createLocation(Location location) {
        Location newLocation = new Location();
        newLocation.setShelf(location.getShelf());
        newLocation.setAisle(location.getAisle());
        return locationRepository.save(newLocation);
    }

    public Location updateLocation(Long locationId, Location location) {
        Location ammendedLocation = locationRepository.findById(locationId)
                .orElseThrow(() -> new EntityNotFoundException("Location with id " + locationId + " not found!"));

        ammendedLocation.setAisle(location.getAisle());
        ammendedLocation.setShelf(location.getShelf());
        return locationRepository.save(ammendedLocation);
    }

    public void deleteLocation(Long locationId) {
        Location locationToDelete = locationRepository.findById(locationId)
                .orElseThrow(() -> new EntityNotFoundException("Location with id " + locationId + " not found!"));

        locationRepository.delete(locationToDelete);
    }
}
