/**
 *
 */
package com.magerwa.vehicle.dto;

import com.magerwa.util.audit.AuditingDTO;
import com.magerwa.vehicle.domain.VehicleConfiguration;
import lombok.*;

/**
 * @author NGANGO
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleConfigurationDTO extends AuditingDTO {
    private String id;
    private String description;
    private String level;
    private VehicleConfiguration parent;
}