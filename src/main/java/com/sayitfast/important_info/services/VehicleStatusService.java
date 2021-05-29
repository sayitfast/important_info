package com.sayitfast.important_info.services;

import com.sayitfast.important_info.models.VehicleStatus;
import com.sayitfast.important_info.repositories.VehicleStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleStatusService {
    @Autowired
    private VehicleStatusRepository vehicleStatusRepository;

    //Return list of countries
    public List<VehicleStatus> getVehicleStatuses() {
        return vehicleStatusRepository.findAll();
    }

    //SAve new VehicleStatus
    public void save(VehicleStatus vehicleStatus) {
        vehicleStatusRepository.save(vehicleStatus);
    }

    //get by id
    public Optional<VehicleStatus> findById(int id) {
        return vehicleStatusRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleStatusRepository.deleteById(id);
    }

}
