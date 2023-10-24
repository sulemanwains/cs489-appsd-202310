package edu.miu.cs489.lab10.surgery.repository;

import edu.miu.cs489.lab10.surgery.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository  extends JpaRepository<Address, Integer> {
}
