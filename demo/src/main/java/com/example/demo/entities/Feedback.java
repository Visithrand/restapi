package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "feedbacks")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long speechId;
    private String userId;
    private String comments;
    private int rating;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getSpeechId() { return speechId; }
    public void setSpeechId(Long speechId) { this.speechId = speechId; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
}
