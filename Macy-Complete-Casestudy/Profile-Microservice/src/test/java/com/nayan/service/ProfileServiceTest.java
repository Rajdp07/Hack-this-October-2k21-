package com.nayan.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import com.nayan.exception.ProfileNotFoundException;
import com.nayan.model.ProfileModel;
import com.nayan.repository.ProfileRepository;
import com.nayan.service.ProfileService;

class ProfileServiceTest {
	@Mock
	ProfileRepository profileRepository;

	@Mock
	private MessageChannel output;
	@InjectMocks

	ProfileService profileService;

	ProfileModel testProfile = new ProfileModel(1L, "Profile X", "ProfileType", "Criteria1", "XYZCritera", "Shipment");
	ProfileModel testProfile2 = new ProfileModel(2L, "Profile Y", "ProfileType", "Criteria2", "ABCCritera", "Shipment");
	List<ProfileModel> profiles = new ArrayList<ProfileModel>();

	@BeforeEach
	void setUpBeforeClass() {
		MockitoAnnotations.initMocks(this);
		profiles.add(testProfile);
		profiles.add(testProfile2);
	}

	@Test
	void testGetAllProfile() {
		when(profileRepository.findAll()).thenReturn(profiles);
		assertEquals(200, profileService.getAllProfile().getStatusCodeValue());

	}

	@Test
	void testSaveProfile() {
		Mockito.when(output.send(MessageBuilder.withPayload(testProfile.getProfileType() + " Profile Created").build()))
				.thenReturn(true);
		when(profileRepository.save(testProfile)).thenReturn(testProfile);
		assertEquals(200, profileService.saveProfile(testProfile).getStatusCodeValue());
	}

	@Test
	void testUpdateProfile() throws Exception {
		Mockito.when(output.send(MessageBuilder.withPayload(testProfile.getProfileType() + " Profile Updated").build()))
				.thenReturn(true);
		when(profileRepository.save(testProfile)).thenReturn(testProfile);
		when(profileRepository.findById(testProfile.getProfileId())).thenReturn(Optional.of(testProfile));
		assertEquals(200, profileService.updateProfile(testProfile).getStatusCodeValue());
	}

	@Test
	void testUpdateProfileProfileNotFound() throws ProfileNotFoundException {

		when(profileRepository.findById(testProfile.getProfileId())).thenReturn(Optional.empty());
		Throwable e = assertThrows(ProfileNotFoundException.class, () -> profileService.updateProfile(testProfile));
		assertEquals("Could not find the Profile with Profile Id " + testProfile.getProfileId(), e.getMessage());

	}

	@Test
	void testDeleteProfile() {
		Mockito.when(output.send(MessageBuilder.withPayload("Profile Deleted").build())).thenReturn(true);
		when(profileRepository.findById(testProfile.getProfileId())).thenReturn(Optional.of(testProfile));
		assertEquals(200, profileService.deleteProfile(testProfile.getProfileId()).getStatusCodeValue());
	}

	@Test
	void testDeleteProfileProfileNotFound() throws ProfileNotFoundException {
		when(profileRepository.findById(testProfile.getProfileId())).thenReturn(Optional.empty());
		Throwable e = assertThrows(ProfileNotFoundException.class,
				() -> profileService.deleteProfile(testProfile.getProfileId()));
		assertEquals("Could not find the Profile with Profile Id " + testProfile.getProfileId(), e.getMessage());
	}

}
