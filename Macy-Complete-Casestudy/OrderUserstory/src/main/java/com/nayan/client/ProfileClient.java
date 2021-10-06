package com.nayan.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.nayan.DTO.ProfileModel;

@FeignClient(name="profile-service",url="${feign.url}")
public interface ProfileClient {
	@GetMapping("/details")
	public List<ProfileModel> getAllProfileDetails();
	
}
