/**
 *
 */
package com.magerwa.vehicle.service;


import com.magerwa.exceptions.CustomRequestException;
import com.magerwa.vehicle.domain.VehicleConfiguration;

import java.util.List;

/**
 * @author NGANGO
 */
public interface VehicleConfigurationService {

    List<VehicleConfiguration> findAll() throws CustomRequestException;

    VehicleConfiguration findById(final String id) throws CustomRequestException;

    void save(final VehicleConfiguration vehicleConfiguration) throws CustomRequestException;

    void deleteById(final String id) throws CustomRequestException;

}