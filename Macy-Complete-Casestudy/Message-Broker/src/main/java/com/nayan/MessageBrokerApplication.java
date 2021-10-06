package com.nayan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.nayan.model.ProfileModel;


@SpringBootApplication
@EnableBinding(Sink.class)
public class MessageBrokerApplication {

	private Logger logger = LoggerFactory.getLogger(MessageBrokerApplication.class);

	@StreamListener(target=Sink.INPUT)
	public void consumeMessage(String message) {
		logger.info("Consume Payload: " + message);
	}

	public static void main(String[] args) {
		SpringApplication.run(MessageBrokerApplication.class, args);
	}

}
