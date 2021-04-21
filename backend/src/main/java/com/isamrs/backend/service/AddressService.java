package com.isamrs.backend.service;

import com.isamrs.backend.model.Address;

public interface AddressService {
    Address findByStreetAndCityAndZipAndCountry(String street, String city, int zip, String country);
}
