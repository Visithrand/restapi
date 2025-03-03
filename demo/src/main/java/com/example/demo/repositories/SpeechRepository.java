package com.example.demo.repositories;

import com.example.demo.entities.Speech;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeechRepository extends JpaRepository<Speech, Long> {
    // Additional query methods can be defined here
}
