package com.isamrs.backend.repository;

import com.isamrs.backend.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findByStreetAndCityAndZipAndCountry(String street, String city, Integer zip, String country);
}
