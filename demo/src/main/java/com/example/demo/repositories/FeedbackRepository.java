package com.example.demo.repositories;

import com.example.demo.entities.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    // Custom JPQL query to find feedbacks by speechId
    @Query("SELECT f FROM Feedback f WHERE f.speechId = :speechId")
    List<Feedback> findBySpeechId(@Param("speechId") Long speechId);

    // Find feedbacks with rating greater than a specified value
    List<Feedback> findByRatingGreaterThan(int rating);

    // Paginated query to get feedback sorted by rating
    Page<Feedback> findAll(Pageable pageable);
}
