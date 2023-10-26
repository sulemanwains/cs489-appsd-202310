package com.example.repo;

import com.example.entity.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurgeryRepo extends JpaRepository<Surgery, Long> {
}
