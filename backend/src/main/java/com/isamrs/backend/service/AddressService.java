package com.isamrs.backend.service;

import com.isamrs.backend.model.Address;

public interface AddressService {
    Address findByStreetAndCityAndZip(String street, String city, int zip);
}
