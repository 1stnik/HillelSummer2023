package com.hillel.springboot.mongo.controller;

import com.hillel.springboot.mongo.model.Developer;
import com.hillel.springboot.mongo.repository.DeveloperRepository;
import java.util.List;

import com.hillel.springboot.mongo.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hillel.springboot.mongo.repository.UserRepository;
import com.hillel.springboot.mongo.model.User;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final UserRepository userRepository;
	private final DeveloperRepository developerRepository;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public User addNewUsers(@RequestBody User user) {
		LOG.info("Saving user.");
		return userRepository.save(user);
	}

	@RequestMapping(value = "/create/developer", method = RequestMethod.POST)
	public Developer addNewUsers(@RequestBody Developer user) {
		LOG.info("Saving user.");
		return developerRepository.save(user);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		LOG.info("Getting all users.");
		return userRepository.findAll();
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public User getUser(@PathVariable String userId) {
		LOG.info("Getting user with ID: {}.", userId);
		return userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
	}
}
