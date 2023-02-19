package com.example.cfttest.repository;

import com.example.cfttest.model.entities.LaptopsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopsRepo extends JpaRepository<LaptopsEntity, Long> {
}
