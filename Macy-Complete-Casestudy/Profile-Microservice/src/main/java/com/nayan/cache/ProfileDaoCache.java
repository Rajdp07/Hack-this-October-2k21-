package com.nayan.cache;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.nayan.exception.ProfileNotFoundException;
import com.nayan.model.ProfileModel;
import com.nayan.service.ProfileService;

@Repository
public class ProfileDaoCache {
    
	public static final String HASH_KEY = "Profile";

	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate template;

	@Autowired
	private ProfileService service;

	@SuppressWarnings("unchecked")
	public ResponseEntity<ProfileModel> save(ProfileModel model) {
		template.opsForHash().put(HASH_KEY, model.getProfileId(), model);

		service.saveProfile(model);

		return new ResponseEntity<ProfileModel>(model, HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<List<ProfileModel>> findAll() {

		List<ProfileModel> models = template.opsForHash().values(HASH_KEY);
		if (models.isEmpty()) {
			return service.getAllProfile();
		} else
			return new ResponseEntity<List<ProfileModel>>(models, HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	public Object findProfileById(long profileId) {

		return (template.opsForHash().get(HASH_KEY, profileId));
	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<ProfileModel> updateProfile(ProfileModel model) throws ProfileNotFoundException {
		ResponseEntity<List<ProfileModel>> models = findAll();
		if (models.hasBody()) {
			for (ProfileModel m : models.getBody()) {
				if (m.getProfileId().equals(model.getProfileId())) {
					m.setProfileName(model.getProfileName());
					m.setProfileType(model.getProfileType());
					m.setCriteriaName(model.getCriteriaName());
					m.setCriteriaValue(model.getCriteriaValue());
					m.setGenerateShipment(model.getGenerateShipment());
					template.opsForHash().put(HASH_KEY, m.getProfileId(), m);

					return new ResponseEntity<ProfileModel>(m, HttpStatus.OK);
				}
			}
		}
		return service.updateProfile(model);

	}

	@SuppressWarnings("unchecked")
	public ResponseEntity<String> deleteProfile(long profileId) {

		if (findProfileById(profileId) != null) {
			template.opsForHash().delete(HASH_KEY, profileId);
			return ResponseEntity.status(HttpStatus.OK)
					.body("Profile id " + Long.toString(profileId) + " deleted successfully");

		} else {
			return service.deleteProfile(profileId);
		}

	}

}
