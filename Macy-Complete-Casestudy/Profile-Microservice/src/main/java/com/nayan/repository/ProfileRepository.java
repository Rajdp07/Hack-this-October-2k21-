package com.nayan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nayan.model.ProfileModel;

public interface ProfileRepository  extends JpaRepository<ProfileModel,Long>{


}
