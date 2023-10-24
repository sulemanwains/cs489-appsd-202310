package edu.miu.lab9springsecurity.repository;

import edu.miu.lab9springsecurity.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
