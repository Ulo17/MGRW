package com.magerwa.vehicle.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import com.magerwa.vehicle.domain.Vehicle;

import java.util.List;

/**
 * @author NGANGO
 */
@Transactional
public interface VehicleDAO extends JpaRepository<Vehicle, String> {
    @Query("SELECT v FROM Vehicle v")
    List<Vehicle> findAll();
}