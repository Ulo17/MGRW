package com.magerwa.vehicle.domain;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.magerwa.util.audit.AuditingExtension;
import lombok.*;
import org.hibernate.annotations.Type;

import lombok.ToString.Include;

/**
 * The Class Vehicle Configuration.
 * 
 * @author NGANGO
 */
@Entity
@Table(name = "VEHICLE_CONFIGURATION", uniqueConstraints = { @UniqueConstraint(columnNames = { "LEVEL", "NAME" }) })
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
public class VehicleConfiguration extends AuditingExtension {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	/** The model or make name. */
	@NotNull(message = "Make or Model cannot be empty")
	@lombok.EqualsAndHashCode.Include
	@Include
	@Column(name = "NAME", nullable = false)
	private String name;

	/** The description. */
	@Type(type = "text")
	@Column(name = "DESCRIPTION", nullable = true)
	private String description;

	/** The level. */
	@NotNull(message = "Level cannot be empty")
	@Size(max = 2, message = "Level size should not exceed 2 characters")
	@Column(name = "LEVEL", nullable = false, length = 1)
	private String level;

	/** The parent. */
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "PARENT_ID", nullable = true)
	private VehicleConfiguration parent;

	/** The children. */
	@Transient
	private List<VehicleConfiguration> children;

	/** The visible. */
	@Transient
	private boolean visible;

}
