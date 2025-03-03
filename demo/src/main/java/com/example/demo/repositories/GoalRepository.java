package com.example.demo.repositories;

import com.example.demo.entities.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goal, Long> {
    // Additional query methods can be defined here
}
