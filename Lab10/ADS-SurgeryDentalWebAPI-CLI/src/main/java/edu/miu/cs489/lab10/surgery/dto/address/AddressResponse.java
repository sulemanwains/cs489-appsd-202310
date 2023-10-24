package edu.miu.cs489.lab10.surgery.dto.address;

public record AddressResponse (
        Integer addressId,
        String street,
        String city,
        String state,
        String zipCode){
}
