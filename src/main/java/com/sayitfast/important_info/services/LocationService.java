package com.sayitfast.important_info.services;

import com.sayitfast.important_info.models.Location;
import com.sayitfast.important_info.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    //Return list of countries
    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

    //SAve new Location
    public void save(Location location) {
        locationRepository.save(location);
    }

    //get by id
    public Optional<Location> findById(int id) {
        return locationRepository.findById(id);
    }

    public void delete(Integer id) {
        locationRepository.deleteById(id);
    }


}
