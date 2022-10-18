package com.magerwa.vehicle.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.*;
import lombok.EqualsAndHashCode.Include;

import com.magerwa.util.audit.AuditingExtension;

/**
 * The Class Vehicle.
 * 
 * @author NGANGO
 */
@Entity
@Table(name = "VEHICLE", uniqueConstraints = { @UniqueConstraint(columnNames = { "PLATE_NUMBER" }),
		@UniqueConstraint(columnNames = { "CHASSIS_NUMBER" }) })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class Vehicle extends AuditingExtension {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	/** The engine number. */
	@NotNull(message = "The plate number cannot be empty")
	@Column(name = "PLATE_NUMBER", nullable = false)
	@Size(min = 6, max = 8, message = "The plate number must be 6 to 8 characters")
	@Include
	@lombok.ToString.Include
	private String plateNumber;

	/** The chassis number. */
	@NotNull(message = "The chassis number cannot be empty")
	@Column(name = "CHASSIS_NUMBER", nullable = false)
	@Size(min = 17, max = 17, message = "The chassis number must be 17 characters")
	@Include
	@lombok.ToString.Include
	private String chassisNumber;

	/** The fuel type. */
	@NotNull(message = "The fuel type cannot be empty")
	@Column(name = "FUEL_TYPE", nullable = false)
	private String fuelType;

	/** The vehicle type. */
	@NotNull(message = "The vehicle type cannot be empty")
	@Column(name = "TYPE", nullable = false)
	private String type;

	/** The manufacture year. */
	@NotNull(message = "The manufacture year cannot be empty")
	@Column(name = "MANUFACTURE_YEAR", nullable = false)
	private Integer manufactureYear;

	/** The initial mileage. */
	@NotNull(message = "The initial mileage cannot be empty")
	@Column(name = "INITIAL_MILEAGE", nullable = false, precision = 10, scale = 2)
	@DecimalMin(value = "0.00", message = "Minimum initial mileage value is 0.00")
	private BigDecimal initialMileage;

	@ManyToOne
	@JoinColumn(name = "MODEL", nullable = true)
	private VehicleConfiguration model;

	@Column(name = "ARRIVAL_DATE", nullable = true)
	private LocalDate arrivalDate;

	@Column(name = "EXIT_DATE", nullable = true)
	private LocalDate exitDate;

}
