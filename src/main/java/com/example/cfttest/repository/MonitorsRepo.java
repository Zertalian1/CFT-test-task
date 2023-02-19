package com.example.cfttest.repository;

import com.example.cfttest.model.entities.MonitorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitorsRepo extends JpaRepository<MonitorsEntity, Long> {
}
