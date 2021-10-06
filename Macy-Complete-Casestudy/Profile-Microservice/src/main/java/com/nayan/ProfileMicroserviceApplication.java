package com.nayan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.nayan.model.ProfileModel;


@SpringBootApplication
@EnableBinding(Source.class)
public class ProfileMicroserviceApplication {

	
	

	
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProfileMicroserviceApplication.class, args);
	}

}
