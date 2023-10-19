package com.example.Service;

import com.example.dtos.address.AddressResponseList;

import java.util.List;

public interface AddressService {
    List<AddressResponseList> getAllAddresses();
}
