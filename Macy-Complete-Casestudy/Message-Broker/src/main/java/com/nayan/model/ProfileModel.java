package com.nayan.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProfileModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long profileId;

	private String profileName;

	private String profileType;

	private String criteriaName;

	private String criteriaValue;

	private String generateShipment;

}
