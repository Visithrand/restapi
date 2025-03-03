package com.example.demo.services;

import com.example.demo.entities.Speech;
import com.example.demo.repositories.SpeechRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpeechService {
    @Autowired
    private SpeechRepository speechRepository;

    public List<Speech> findAll() {
        return speechRepository.findAll();
    }

    public Optional<Speech> findById(Long id) {
        return speechRepository.findById(id);
    }

    public Speech save(Speech speech) {
        return speechRepository.save(speech);
    }

    public void deleteById(Long id) {
        speechRepository.deleteById(id);
    }
}
