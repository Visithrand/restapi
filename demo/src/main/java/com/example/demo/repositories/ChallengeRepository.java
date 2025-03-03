package com.example.demo.repositories;

import com.example.demo.entities.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
    // Additional query methods can be defined here
}
