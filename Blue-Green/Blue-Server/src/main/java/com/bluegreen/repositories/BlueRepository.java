package com.bluegreen.repositories;

import com.bluegreen.entities.Blue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlueRepository extends JpaRepository<Blue, Integer> {
}
