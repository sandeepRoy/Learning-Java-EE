package com.bluegreen.repositories;

import com.bluegreen.entities.Green;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreenRepository extends JpaRepository<Green, Integer> {
}
