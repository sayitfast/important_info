package com.sayitfast.important_info.services;

import com.sayitfast.important_info.models.VehicleHire;
import com.sayitfast.important_info.repositories.VehicleHireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleHireService {

    @Autowired
    private VehicleHireRepository vehicleHireRepository;

    //Return list of Vehicle Hire
    public List<VehicleHire> getVehicleHires() {
        return vehicleHireRepository.findAll();
    }

    //SAve new VehicleHire
    public void save(VehicleHire vehicleHire) {
        vehicleHireRepository.save(vehicleHire);
    }

    //get by id
    public Optional<VehicleHire> findById(int id) {
        return vehicleHireRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleHireRepository.deleteById(id);
    }


}
