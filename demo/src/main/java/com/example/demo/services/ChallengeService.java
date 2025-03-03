package com.example.demo.services;

import com.example.demo.entities.Challenge;
import com.example.demo.repositories.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChallengeService {
    @Autowired
    private ChallengeRepository challengeRepository;

    public List<Challenge> findAll() {
        return challengeRepository.findAll();
    }

    public Optional<Challenge> findById(Long id) {
        return challengeRepository.findById(id);
    }

    public Challenge save(Challenge challenge) {
        return challengeRepository.save(challenge);
    }

    public void deleteById(Long id) {
        challengeRepository.deleteById(id);
    }
}
