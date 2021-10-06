package com.nayan.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nayan.cache.ProfileDaoCache;
import com.nayan.exception.InvalidProfileException;
import com.nayan.exception.ProfileNotFoundException;
import com.nayan.model.ProfileModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/profile")

public class ProfileController {

	@Autowired
	private transient ProfileDaoCache cache;



	@GetMapping("/details")
	public ResponseEntity<List<ProfileModel>> getAllProfileDetails() {
		log.info("All profile Details retreived from cache :: {}");
		return cache.findAll();
	}

	@PostMapping("/saveprofile")
	public ResponseEntity<ProfileModel> saveProfile(@Valid @RequestBody ProfileModel model)
			throws InvalidProfileException {
		
		log.info(" Proile saved :: {}", model);
		return cache.save(model);
	}

	@PutMapping("/updateprofile")
	public ResponseEntity<ProfileModel> updateProfile(@Valid @RequestBody ProfileModel model)
			throws InvalidProfileException {
	
		log.info("Profile updated :: {}", model);
		return cache.updateProfile(model);
	}

	@DeleteMapping("/deleteprofile/{profileId}")
	public ResponseEntity<String> deleteProfile(@PathVariable long profileId) throws ProfileNotFoundException {
		//output.send(MessageBuilder.withPayload(model).build());
		log.info("Profile Deleted with profile id:: {}", profileId);
		return cache.deleteProfile(profileId);
	}









}
