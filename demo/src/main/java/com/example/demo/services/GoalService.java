package com.example.demo.services;

import com.example.demo.entities.Goal;
import com.example.demo.repositories.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoalService {
    @Autowired
    private GoalRepository goalRepository;

    public List<Goal> findAll() {
        return goalRepository.findAll();
    }

    public Optional<Goal> findById(Long id) {
        return goalRepository.findById(id);
    }

    public Goal save(Goal goal) {
        return goalRepository.save(goal);
    }

    public void deleteById(Long id) {
        goalRepository.deleteById(id);
    }
}
