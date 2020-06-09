package com.example.virus.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.virus.entity.Cities;

@Repository
public interface CityRepo extends JpaRepository<Cities, Integer> {

}
