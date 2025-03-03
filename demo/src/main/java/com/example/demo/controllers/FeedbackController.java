package com.example.demo.controllers;

import com.example.demo.entities.Feedback;
import com.example.demo.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping
    public Page<Feedback> getAllFeedbacks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return feedbackService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable Long id) {
        return feedbackService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Feedback createFeedback(@RequestBody Feedback feedback) {
        return feedbackService.save(feedback);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable Long id, @RequestBody Feedback feedback) {
        feedback.setId(id);
        return ResponseEntity.ok(feedbackService.save(feedback));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<Feedback> findBySpeechId(@RequestParam Long speechId) {
        return feedbackService.findBySpeechId(speechId);
    }

    @GetMapping("/high-rating")
    public List<Feedback> getHighRatedFeedbacks(@RequestParam int minRating) {
        return feedbackService.findByRatingGreaterThan(minRating);
    }
}
