package com.isamrs.backend.controller;

import com.isamrs.backend.dto.LoginDTO;
import com.isamrs.backend.dto.LoginUserDTO;
import com.isamrs.backend.dto.UpdateProfileDTO;
import com.isamrs.backend.dto.UserDTO;
import com.isamrs.backend.model.User;
import com.isamrs.backend.repository.UserRepository;
import com.isamrs.backend.security.TokenUtils;
import com.isamrs.backend.service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private TokenUtils tokenUtils;

    private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());


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

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginUserDTO> login(@RequestBody LoginDTO log) {
        logger.info(">> login: email - " + log.getEmail() + " password - " + log.getPassword());

        try {

            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(log.getEmail(),
                    log.getPassword());
            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            HttpHeaders headers = new HttpHeaders();

            // Reload user details so we can generate token
            UserDetails details = userDetailsService.loadUserByUsername(log.getEmail());

            String authToken = tokenUtils.generateToken(details);
            headers.add("X-Auth-Token", authToken);
            String userRoleType = "";
            LoginUserDTO lu = new LoginUserDTO();
            User user = userService.getUser(log.getEmail());
            logger.info(user.getEmail() + ' ' + user.getPassword());
            if (user != null) {
                userRoleType = user.getRoleType().name();
                logger.info(userRoleType);
                lu.setRoleType(userRoleType);
                lu.setToken(authToken);
            } else {
                logger.info("user does not exist");
                return new ResponseEntity<LoginUserDTO>(lu, HttpStatus.BAD_REQUEST);
            }

            logger.info("<< logged");
            return new ResponseEntity<LoginUserDTO>(lu, headers, HttpStatus.OK);

        } catch (Exception ex) {
            logger.info("invalid login");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> update(@RequestBody UpdateProfileDTO profileDTO) {

        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        User user = userService.UpdateDTOtoUser(profileDTO);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        boolean updated = userService.update(user);

        if (updated == true) {
            return new ResponseEntity<String>("OK", HttpStatus.OK);

        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
