package edu.miu.lab6.cs489.repo;

import edu.miu.lab6.cs489.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SurgeryRepo  extends JpaRepository<Surgery, Long> {
}
