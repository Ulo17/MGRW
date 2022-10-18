/**
 *
 */
package com.magerwa.vehicle.service.impl;

import com.magerwa.exceptions.CustomRequestException;
import com.magerwa.util.Constants;
import com.magerwa.vehicle.dao.VehicleConfigurationDAO;
import com.magerwa.vehicle.domain.VehicleConfiguration;
import com.magerwa.vehicle.service.VehicleConfigurationService;
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
public class VehicleConfigurationServiceImpl implements VehicleConfigurationService {

    private final VehicleConfigurationDAO vehicleRepository;

    @Autowired
    public VehicleConfigurationServiceImpl(VehicleConfigurationDAO theVehicleRepository) {
        vehicleRepository = theVehicleRepository;
    }

    @Override
    public List<VehicleConfiguration> findAll() throws CustomRequestException {
        return vehicleRepository.findAll();
    }

    @Override
    public VehicleConfiguration findById(final String id) throws CustomRequestException {
        Map<String, String> map = new HashMap<>();
        Optional<VehicleConfiguration> result = vehicleRepository.findById(id);
        VehicleConfiguration theVehicle = null;
        if (result.isPresent()) {
            theVehicle = result.get();
        } else {
            map.put(Constants.MESSAGE, Constants.VEHICLE_CONFIGURATION_NOT_FOUND);
            new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
        return theVehicle;
    }

    @Override
    public void save(final VehicleConfiguration vehicle) throws CustomRequestException {
        vehicleRepository.save(vehicle);
    }

    @Override
    public void deleteById(final String id) throws CustomRequestException {
        vehicleRepository.deleteById(id);
    }

}