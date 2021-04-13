package com.isamrs.backend.service.impl;

import com.isamrs.backend.model.Address;
import com.isamrs.backend.repository.AddressRepository;
import com.isamrs.backend.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address findByStreetAndCityAndZip(String street, String city, int zip) {
        return addressRepository.findByStreetAndCityAndZip(street, city, zip);
    }

}
