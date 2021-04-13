package com.isamrs.backend.controller;

import com.isamrs.backend.dto.UserDTO;
import com.isamrs.backend.model.User;
import com.isamrs.backend.repository.UserRepository;
import com.isamrs.backend.security.TokenUtils;
import com.isamrs.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;


    @Autowired
    TokenUtils tokenUtils;


    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addUser(@RequestBody UserDTO user) {
        try {

            if (userService.getUser(user.getEmail()) != null) {
                return new ResponseEntity<String>(HttpStatus.CONFLICT);
            }

            user.setRoleType("PATIENT");

            userService.saveUser(userService.UserDTOToUser(user));
            return new ResponseEntity<String>(HttpStatus.CREATED);
        } catch (Exception ex) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }

    }
}
