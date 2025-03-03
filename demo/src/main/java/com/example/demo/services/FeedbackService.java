package com.example.demo.services;

import com.example.demo.entities.Feedback;
import com.example.demo.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    public Page<Feedback> findAll(Pageable pageable) {
        return feedbackRepository.findAll(pageable);
    }

    public Optional<Feedback> findById(Long id) {
        return feedbackRepository.findById(id);
    }

    public Feedback save(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public void deleteById(Long id) {
        feedbackRepository.deleteById(id);
    }

    public List<Feedback> findBySpeechId(Long speechId) {
        return feedbackRepository.findBySpeechId(speechId);
    }

    public List<Feedback> findByRatingGreaterThan(int rating) {
        return feedbackRepository.findByRatingGreaterThan(rating);
    }
}
