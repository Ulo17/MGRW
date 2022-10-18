package com.magerwa.vehicle.dao;

import com.magerwa.vehicle.domain.VehicleConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author NGANGO
 */
@Transactional
public interface VehicleConfigurationDAO extends JpaRepository<VehicleConfiguration, String> {
    @Query("SELECT vc FROM VehicleConfiguration vc")
    List<VehicleConfiguration> findAll();
}