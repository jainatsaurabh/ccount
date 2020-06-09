package com.example.virus.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.virus.entity.States;

@Repository
public interface StateRepo extends JpaRepository<States, String> {

}
