package com.isamrs.backend.service.impl;

import com.isamrs.backend.dto.UpdateProfileDTO;
import com.isamrs.backend.dto.UserDTO;
import com.isamrs.backend.enumeration.RoleType;
import com.isamrs.backend.model.Address;
import com.isamrs.backend.model.Authority;
import com.isamrs.backend.model.User;
import com.isamrs.backend.repository.AddressRepository;
import com.isamrs.backend.repository.AuthorityRepository;
import com.isamrs.backend.repository.UserRepository;
import com.isamrs.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private Environment env;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User getUser(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User getUserEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public User UserDTOToUser(UserDTO userDTO) {
        User u = new User();

        u.setName(userDTO.getName());
        u.setSurname(userDTO.getSurname());
        u.setEmail(userDTO.getEmail());
        u.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        Address a = addressRepository.findByStreetAndCityAndZipAndCountry(userDTO.getAddress().getStreet(),
                userDTO.getAddress().getCity(), userDTO.getAddress().getZip(), userDTO.getAddress().getCountry());
        if(a == null) {
            a = new Address();
            a.setStreet(userDTO.getAddress().getStreet());
            a.setCity(userDTO.getAddress().getCity());
            a.setZip(userDTO.getAddress().getZip());
            a.setCountry(userDTO.getAddress().getCountry());
            addressRepository.save(a);
        }
        u.setAddress(a);

        if(userDTO.getRoleType().equals("ADMIN_SYSTEM")) {
            u.setRoleType(RoleType.ADMIN_SYSTEM);
        }
        else if(userDTO.getRoleType().equals("ADMIN_PHARMACY")) {
            u.setRoleType(RoleType.ADMIN_PHARMACY);

        }
        else if(userDTO.getRoleType().equals("DERMATOLOGIST")){
            u.setRoleType(RoleType.DERMATOLOGIST);
        }
        else if(userDTO.getRoleType().equals("PHARMACIST")){
            u.setRoleType(RoleType.PHARMACIST);
        }
        else if(userDTO.getRoleType().equals("SUPPLIER")){
            u.setRoleType(RoleType.SUPPLIER);
        }
        else if(userDTO.getRoleType().equals("PATIENT")){
            u.setRoleType(RoleType.PATIENT);
        }

        return u;
    }

    @Override
    public boolean saveUser(User u) {
        if(userRepository.findUserByEmail(u.getEmail()) != null) {
            return false;
        }
        if(u.getRoleType() == RoleType.PATIENT) {
            User user = new User(u.getName(), u.getSurname(), u.getEmail(),u.getPassword(),
                    u.getRoleType(), u.getAddress(), u.getAuthority());
            User saveUser = userRepository.save(user);
            Authority a = new Authority("PATIENT", saveUser);
            authorityRepository.save(a);
            return true;
        }
        else if(u.getRoleType() == RoleType.DERMATOLOGIST) {
            User user = new User(u.getName(), u.getSurname(), u.getEmail(),u.getPassword(),
                    u.getRoleType(), u.getAddress(), u.getAuthority());
            User saveUser = userRepository.save(user);
            Authority a = new Authority("DERMATOLOGIST", saveUser);
            authorityRepository.save(a);
            return true;
        }
        else if(u.getRoleType() == RoleType.PHARMACIST) {
            User user = new User(u.getName(), u.getSurname(), u.getEmail(),u.getPassword(),
                    u.getRoleType(), u.getAddress(), u.getAuthority());
            User saveUser = userRepository.save(user);
            Authority a = new Authority("PHARMACIST", saveUser);
            authorityRepository.save(a);
            return true;
        }
        else if(u.getRoleType() == RoleType.SUPPLIER) {
            User user = new User(u.getName(), u.getSurname(), u.getEmail(),u.getPassword(),
                    u.getRoleType(), u.getAddress(), u.getAuthority());
            User saveUser = userRepository.save(user);
            Authority a = new Authority("SUPPLIER", saveUser);
            authorityRepository.save(a);
            return true;
        }
        else if(u.getRoleType() == RoleType.ADMIN_PHARMACY) {
            User user = new User(u.getName(), u.getSurname(), u.getEmail(),u.getPassword(),
                    u.getRoleType(), u.getAddress(), u.getAuthority());
            User saveUser = userRepository.save(user);
            Authority a = new Authority("ADMIN_PHARMACY", saveUser);
            authorityRepository.save(a);
            return true;
        }
        else if(u.getRoleType() == RoleType.ADMIN_SYSTEM) {
            User saveUser = userRepository.save(u);
            Authority a = new Authority("ADMIN_SYSTEM", saveUser);
            authorityRepository.save(a);
            return true;
        }
        return false;
    }

    @Override
    public User UpdateDTOtoUser(UpdateProfileDTO profileDTO) {
        User user = userRepository.findUserByEmail(profileDTO.getEmail());
        if (user == null) {return null;}

        if (user.getName()!=profileDTO.getName() || profileDTO.getName()!="") {
            user.setName(profileDTO.getName());
        }

        if (user.getSurname()!=profileDTO.getSurname() || profileDTO.getSurname()!="") {
            user.setSurname(profileDTO.getSurname());
        }

        if (user.getPassword()!=profileDTO.getPassword() || profileDTO.getPassword()!="") {
            if(profileDTO.getPassword()=="") {
                user.setPassword(user.getPassword());
            }
            else {
                user.setPassword(profileDTO.getPassword());}
        }

        Address a = addressRepository.findByStreetAndCityAndZipAndCountry(profileDTO.getAddress().getStreet(),
                profileDTO.getAddress().getCity(), profileDTO.getAddress().getZip(), profileDTO.getAddress().getCountry());
        if (a == null){
            a = new Address();
            a.setStreet(profileDTO.getAddress().getStreet());
            a.setCity(profileDTO.getAddress().getCity());
            a.setZip(profileDTO.getAddress().getZip());
            a.setCountry(profileDTO.getAddress().getCountry());
            addressRepository.save(a);
        }

        user.setAddress(a);

        return user;
    }

    @Override
    public boolean update(User u) {
        if(u == null) {
            return false;
        }
        try {
            u.setPassword(passwordEncoder.encode(u.getPassword()));
            userRepository.save(u);
            return true;
        }catch(Exception e){
            return false;}
    }
}
