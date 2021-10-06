package com.nayan.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import org.springframework.integration.support.MessageBuilder;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nayan.cache.ProfileDaoCache;
import com.nayan.controller.ProfileController;
import com.nayan.exception.InvalidProfileException;
import com.nayan.exception.ProfileNotFoundException;
import com.nayan.model.ProfileModel;
import com.nayan.service.ProfileService;

@WebMvcTest(value = ProfileController.class)
//@ExtendWith(MockitoExtension.class)
class ProfileControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	ProfileDaoCache profileService;
	


	static ProfileModel testProfile=new ProfileModel(1L, "Profile X", "Order", "OrderType", "POS", "Y");
	static ProfileModel testProfile2;
	static List<ProfileModel>profiles=new ArrayList<ProfileModel>();
	static ResponseEntity<List<ProfileModel>>responseEntity;

	
		
		@BeforeEach
		public void init() {
			
		profiles.add(new ProfileModel(1L, "Profile X", "Order", "OrderType", "POS", "Y"));
		profiles.add(new ProfileModel(2L, "Profile Y", "Order", "OrderType", "POS", "Y"));
		}

	@Test
	void testGetAllProfileDetails() throws Exception {
		when(profileService.findAll()).thenReturn(ResponseEntity.status(HttpStatus.OK).body(profiles));
		mockMvc.perform(get("/profile/details")).equals(profiles);
	}

	@Test
	void testSaveProfile() throws Exception {
		ProfileModel model=new ProfileModel(1L, "Profile X", "Order", "OrderType", "POS", "Y");
		//Mockito.when(output.send(MessageBuilder.withPayload(model).build())).thenReturn(true);
		when(profileService.save(model)).thenReturn(ResponseEntity.status(HttpStatus.OK).body(model));
		ObjectMapper mapper = new ObjectMapper();
		String str = mapper.writeValueAsString(model);
		mockMvc.perform(post("/profile/saveprofile").contentType(org.springframework.http.MediaType.APPLICATION_JSON).content(str)).andExpect(status().isOk());
		
		
	}
	@Test
	void testUpdateProfile() throws Exception {
		ProfileModel model=new ProfileModel(1L, "Profile X", "Order", "OrderType", "POS", "Y");
		//Mockito.when(output.send(MessageBuilder.withPayload(model).build())).thenReturn(true);
		when(profileService.updateProfile(model)).thenReturn(ResponseEntity.status(HttpStatus.OK).body(model));
		ObjectMapper mapper = new ObjectMapper();
		String str = mapper.writeValueAsString(model);
		mockMvc.perform(put("/profile/updateprofile").contentType(org.springframework.http.MediaType.APPLICATION_JSON).content(str)).andExpect(status().isOk());
		
	}

	@Test
	void testDeleteProfile() throws   Exception {
		when(profileService.deleteProfile(1L)).thenReturn(ResponseEntity.status(HttpStatus.OK).body("Profile id 1 deleted successfully"));
		mockMvc.perform(delete("/profile/deleteprofile/1")).andExpect(status().isOk());
	}
	
//	Mockito.when(messageChannel.send(MessageBuilder.withPayload(profile.getProfiletype()+" Profile Inserted")
//	.build())).thenReturn(true);	
}
