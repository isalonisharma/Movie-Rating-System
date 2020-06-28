package com.usermicroservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usermicroservice.exceptions.UserNotFoundException;
import com.usermicroservice.models.DTO.UserDTO;
import com.usermicroservice.models.requests.CreateUserRequest;
import com.usermicroservice.models.responses.UserResponse;
import com.usermicroservice.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest createUserRequest) {

		UserDTO userDTO = userService.createUser(createUserRequest);
		UserResponse userResponse = new UserResponse(userDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
	}

	@GetMapping(value = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserResponse> getUser(@PathVariable("userId") Long id) throws UserNotFoundException {

		UserDTO userDTO = userService.getUserById(id);
		UserResponse userResponse = new UserResponse(userDTO);
		return ResponseEntity.status(HttpStatus.OK).body(userResponse);
	}
}