package com.nayan.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@XmlRootElement
@Table(name = "Profile")

public class ProfileModel implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull(message="Profile id musn't be blank")
	@Column(name = "PROFILE_ID")
	private Long profileId;
	
	@NotBlank(message = "Name musn't be blank")
	@Column(name = "PROFILE_NAME")
	private String profileName;
	
	@NotBlank(message = "Profile type musn't be blank")
	@Column(name = "PROFILE_TYPE")
	private String profileType;
	
	@NotBlank(message = "Criteria Name musn't be blank")
	@Column(name = "CRITERIA_NAME")
	private String  criteriaName;
	
	@NotBlank(message = "Criteria Value musn't be blank")
	@Column(name = "CRITERIA_VALUE")
	private String criteriaValue;
	
	@NotBlank(message = "Generate Shipment musn't be blank")
	@Column(name = "GENERATE_SHIPMENT")
	private String generateShipment;
	
    

	
	

}
