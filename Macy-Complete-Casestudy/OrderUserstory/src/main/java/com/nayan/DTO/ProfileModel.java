package com.nayan.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class ProfileModel {

	private Long profileId;

	private String profileName;

	private String profileType;

	private String criteriaName;

	private String criteriaValue;

	private String generateShipment;

}
