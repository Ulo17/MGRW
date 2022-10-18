/**
 *
 */
package com.magerwa.vehicle.service.impl;

import com.magerwa.exceptions.CustomRequestException;
import com.magerwa.util.Constants;
import com.magerwa.vehicle.dao.VehicleDAO;
import com.magerwa.vehicle.domain.Vehicle;
import com.magerwa.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author NGANGO
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleDAO vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleDAO theVehicleRepository) {
        vehicleRepository = theVehicleRepository;
    }

    @Override
    public List<Vehicle> findAll() throws CustomRequestException {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle findById(final String id) throws CustomRequestException {
        Map<String, String> map = new HashMap<>();
        Optional<Vehicle> result = vehicleRepository.findById(id);
        Vehicle theVehicle = null;
        if (result.isPresent()) {
            theVehicle = result.get();
        } else {
            map.put(Constants.MESSAGE, Constants.VEHICLE_NOT_FOUND);
            new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
        return theVehicle;
    }

    @Override
    public void save(final Vehicle vehicle) throws CustomRequestException {
        vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteById(final String id) throws CustomRequestException {
        vehicleRepository.deleteById(id);
    }

}