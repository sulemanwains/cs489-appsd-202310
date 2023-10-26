package com.example.repo;

import com.example.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
