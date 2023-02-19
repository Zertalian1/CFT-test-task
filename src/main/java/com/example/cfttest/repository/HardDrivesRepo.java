package com.example.cfttest.repository;


import com.example.cfttest.model.entities.HardDrivesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardDrivesRepo extends JpaRepository<HardDrivesEntity, Long> {
}
