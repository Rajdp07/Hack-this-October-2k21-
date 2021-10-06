package com.nayan.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.nayan.DTO.ProfileModel;



public class ProfileDtoTesting {
	@Test
	void test() {
		ProfileModel testProfile1= new ProfileModel(2L, "Profile Y", "ProfileType", "Criteria2", "ABCCriteria", "Shipment");
		ProfileModel testProfile2= new ProfileModel();
		testProfile2.setProfileId(1L);
		testProfile2.setProfileName("Profile X");
		testProfile2.setProfileType("Order");
		testProfile2.setCriteriaName("OrderType");
		testProfile2.setCriteriaValue("POS");
		testProfile2.setGenerateShipment("Y");
		assertEquals(2L,testProfile1.getProfileId());
		assertEquals("Profile Y",testProfile1.getProfileName());
		assertEquals("ProfileType",testProfile1.getProfileType());
		assertEquals("Criteria2",testProfile1.getCriteriaName());
		assertEquals("ABCCriteria",testProfile1.getCriteriaValue());
		assertEquals("Shipment",testProfile1.getGenerateShipment());
		assertEquals("ProfileModel(profileId=1, profileName=Profile X, profileType=Order, criteriaName=OrderType, criteriaValue=POS, generateShipment=Y)",testProfile2.toString());
	}
}
