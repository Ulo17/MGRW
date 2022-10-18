/**
 *
 */
package com.magerwa.vehicle.dto;

import com.magerwa.util.audit.AuditingDTO;
import com.magerwa.vehicle.domain.VehicleConfiguration;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author NGANGO
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO extends AuditingDTO {
    private String id;
    private String plateNumber;
    private String chassisNumber;
    private String fuelType;
    private String type;
    private Integer manufactureYear;
    private BigDecimal initialMileage;
    private VehicleConfiguration model;
    private LocalDate arrivalDate;
    private LocalDate exitDate;
}