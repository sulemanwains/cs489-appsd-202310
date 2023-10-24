package edu.miu.cs489.lab10.surgery.service;

import edu.miu.cs489.lab10.surgery.dto.address.AddressResponse;
import edu.miu.cs489.lab10.surgery.dto.address.AddressRequest;
import edu.miu.cs489.lab10.surgery.exception.AddressNotFoundException;

import java.util.List;

public interface AddressService {

    List<AddressResponse> getAllAddresses();

    AddressResponse addNewAddress(AddressRequest newAddress);

    AddressResponse getAddressById(Integer addressId) throws AddressNotFoundException;

    AddressResponse updateAddress(AddressRequest addressRequest, int addressId) throws AddressNotFoundException;

    void deleteAddressById(int addressId) throws AddressNotFoundException;
}
