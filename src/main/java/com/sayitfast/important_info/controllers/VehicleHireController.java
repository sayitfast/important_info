package com.sayitfast.important_info.controllers;

import com.sayitfast.important_info.models.VehicleHire;
import com.sayitfast.important_info.services.ClientService;
import com.sayitfast.important_info.services.LocationService;
import com.sayitfast.important_info.services.VehicleHireService;
import com.sayitfast.important_info.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class VehicleHireController {


    @Autowired
    private VehicleHireService vehicleHireService;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private ClientService clientService;


    @GetMapping("/vehicleHires")
    public String getVehicleHires(Model model) {

        model.addAttribute("vehicleHires", vehicleHireService.getVehicleHires());
        model.addAttribute("vehicles", vehicleService.getVehicles());
        model.addAttribute("locations", locationService.getLocations());
        model.addAttribute("clients", clientService.getClients());

        return "vehicleHire";
    }

    @PostMapping("/vehicleHires/addNew")
    public String addNew(VehicleHire vehicleHire) {
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehicleHires";
    }

    @RequestMapping("vehicleHires/findById")
    @ResponseBody
    public Optional<VehicleHire> findById(int id) {
        return vehicleHireService.findById(id);
    }

    @RequestMapping(value = "/vehicleHires/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleHire vehicleHire) {
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehicleHires";
    }

    @RequestMapping(value = "/vehicleHires/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        vehicleHireService.delete(id);
        return "redirect:/vehicleHires";
    }
}
