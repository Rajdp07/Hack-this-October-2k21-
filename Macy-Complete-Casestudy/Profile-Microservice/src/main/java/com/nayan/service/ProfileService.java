package com.nayan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import com.nayan.exception.ProfileNotFoundException;
import com.nayan.repository.ProfileRepository;

import lombok.extern.java.Log;

@Service
@Log
public class ProfileService {

	@Autowired
	ProfileRepository profileRepo;
	@Autowired
	private MessageChannel output;

	public ResponseEntity<List<com.nayan.model.ProfileModel>> getAllProfile() {
		return ResponseEntity.status(HttpStatus.OK).body(profileRepo.findAll());
	}

	public ResponseEntity<com.nayan.model.ProfileModel> saveProfile(com.nayan.model.ProfileModel model) {
		output.send(MessageBuilder.withPayload(model.getProfileType()+" Profile Created").build());
		return ResponseEntity.status(HttpStatus.OK).body(profileRepo.save(model));
	}

	public ResponseEntity<com.nayan.model.ProfileModel> updateProfile(com.nayan.model.ProfileModel newModel) throws ProfileNotFoundException {
		return ResponseEntity.status(HttpStatus.OK).body(profileRepo.findById(newModel.getProfileId()).map(model -> {
			model.setProfileId(newModel.getProfileId());
			model.setProfileName(newModel.getProfileName());
			model.setProfileType(newModel.getProfileType());
			model.setCriteriaName(newModel.getCriteriaName());
			model.setCriteriaValue(newModel.getCriteriaValue());
			model.setGenerateShipment(newModel.getGenerateShipment());
			log.info("Profile details updated");
			output.send(MessageBuilder.withPayload(newModel.getProfileType()+" Profile Updated").build());
			return profileRepo.save(model);
		}).orElseThrow(() -> new ProfileNotFoundException(newModel.getProfileId())));
	}

	public ResponseEntity<String> deleteProfile(long profileId) throws ProfileNotFoundException {
		if (profileRepo.findById(profileId).isPresent()) {
			log.info("Proile deleted successfully");

			profileRepo.deleteById(profileId);
			output.send(MessageBuilder.withPayload("Profile Deleted").build());
			return ResponseEntity.status(HttpStatus.OK)
					.body("Profile id " + Long.toString(profileId) + " deleted successfully");
		} else {
			throw new ProfileNotFoundException(profileId);
		}
	}

}
