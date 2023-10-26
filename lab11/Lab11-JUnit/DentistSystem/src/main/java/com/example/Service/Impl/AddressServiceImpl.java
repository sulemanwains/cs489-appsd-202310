package com.example.Service.Impl;


import com.example.Service.AddressService;
import com.example.dtos.address.AddressResponseList;
import com.example.mapper.AddressMapper;
import com.example.repo.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;
    AddressServiceImpl(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }
    @Override
    public List<AddressResponseList> getAllAddresses() {
        return addressRepository.findAll()
                .stream()
                .map(a -> AddressMapper.addressEntityToAddressResponse(a))
                .sorted(Comparator.comparing(AddressResponseList::city))
                .toList();
    }


}
