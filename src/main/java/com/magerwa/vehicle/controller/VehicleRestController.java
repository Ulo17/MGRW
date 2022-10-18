/**
 *
 */
package com.magerwa.vehicle.controller;

import com.magerwa.exceptions.CustomRequestException;
import com.magerwa.util.Constants;
import com.magerwa.vehicle.domain.Vehicle;
import com.magerwa.vehicle.dto.VehicleDTO;
import com.magerwa.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author NGANGO
 */
@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/vehicles")
public class VehicleRestController {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleRestController(VehicleService theVehicleService) {
        this.vehicleService = theVehicleService;
    }

    @GetMapping
    public List<Vehicle> findAll() throws CustomRequestException {
        return vehicleService.findAll();
    }

    @GetMapping("/{vehicleId}")
    public Vehicle getVehicle(@PathVariable String vehicleId) throws CustomRequestException {
        return vehicleService.findById(vehicleId);
    }

    @PostMapping
    public Vehicle addVehicle(@RequestBody VehicleDTO theVehicle) throws CustomRequestException {
        Vehicle vehicle = new Vehicle();
        vehicle = addInDto(vehicle, theVehicle);
        vehicleService.save(vehicle);
        return vehicle;
    }

    @PutMapping
    public Vehicle updateVehicle(@RequestBody VehicleDTO theVehicle) throws CustomRequestException {
        Vehicle vehicle = vehicleService.findById(theVehicle.getId());
        if (vehicle == null) {
            throw new CustomRequestException(Constants.VEHICLE_NOT_FOUND);
        }
        vehicle = addInDto(vehicle, theVehicle);
        vehicleService.save(vehicle);
        return vehicle;
    }

    @DeleteMapping("/{vehicleId}")
    public String deleteVehicle(@PathVariable String vehicleId) throws CustomRequestException {
        Vehicle tempVehicle = vehicleService.findById(vehicleId);
        if (tempVehicle == null) {
            throw new CustomRequestException(Constants.VEHICLE_NOT_FOUND);
        }
        vehicleService.deleteById(vehicleId);
        return "Deleted vehicle id - " + vehicleId;
    }

    public Vehicle addInDto(Vehicle vehicle, VehicleDTO theVehicle) {
        vehicle.setPlateNumber(theVehicle.getPlateNumber());
        vehicle.setChassisNumber(theVehicle.getChassisNumber());
        vehicle.setFuelType(theVehicle.getFuelType());
        vehicle.setType(theVehicle.getType());
        vehicle.setArrivalDate(theVehicle.getArrivalDate());
        vehicle.setExitDate(theVehicle.getExitDate());
        vehicle.setInitialMileage(theVehicle.getInitialMileage());
        vehicle.setManufactureYear(theVehicle.getManufactureYear());
        vehicle.setModel(theVehicle.getModel());
        return vehicle;
    }
}