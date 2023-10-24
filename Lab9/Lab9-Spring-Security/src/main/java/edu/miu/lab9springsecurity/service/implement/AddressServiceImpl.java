package edu.miu.lab9springsecurity.service.implement;

import edu.miu.lab9springsecurity.models.Address;
import edu.miu.lab9springsecurity.repository.AddressRepository;
import edu.miu.lab9springsecurity.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address addNewAddress(Address newAddress) {
        return addressRepository.save(newAddress);
    }

    @Override
    public Address getAddressById(Integer addressId) {
        return addressRepository.findById(addressId).orElse(null);
    }
}
