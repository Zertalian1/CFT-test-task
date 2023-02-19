package com.example.cfttest.repository;

import com.example.cfttest.model.entities.DesktopComputersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesktopComputersRepo extends JpaRepository<DesktopComputersEntity, Long> {
}
