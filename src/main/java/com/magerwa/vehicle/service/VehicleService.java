/**
 *
 */
package com.magerwa.vehicle.service;


import com.magerwa.exceptions.CustomRequestException;
import com.magerwa.vehicle.domain.Vehicle;

import java.util.List;

/**
 * @author NGANGO
 */
public interface VehicleService {

    List<Vehicle> findAll() throws CustomRequestException;

    Vehicle findById(final String id) throws CustomRequestException;

    void save(final Vehicle vehicle) throws CustomRequestException;

    void deleteById(final String id) throws CustomRequestException;

}