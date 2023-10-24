package edu.miu.lab9springsecurity.service;

import edu.miu.lab9springsecurity.models.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAllAddresses();

    Address addNewAddress(Address newAddress);

    Address getAddressById(Integer addressId);
}
