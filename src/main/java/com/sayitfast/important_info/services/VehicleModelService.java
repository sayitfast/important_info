package com.sayitfast.important_info.services;

import com.sayitfast.important_info.models.VehicleModel;
import com.sayitfast.important_info.repositories.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleModelService {
    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    //Return list of countries
    public List<VehicleModel> getVehicleModels() {
        return vehicleModelRepository.findAll();
    }

    //SAve new VehicleModel
    public void save(VehicleModel vehicleModel) {
        vehicleModelRepository.save(vehicleModel);
    }

    //get by id
    public Optional<VehicleModel> findById(int id) {
        return vehicleModelRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleModelRepository.deleteById(id);
    }

}
