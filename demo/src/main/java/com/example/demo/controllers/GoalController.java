package com.example.demo.controllers;

import com.example.demo.entities.Goal;
import com.example.demo.services.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goals")
public class GoalController {
    @Autowired
    private GoalService goalService;

    @GetMapping
    public List<Goal> getAllGoals() {
        return goalService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Goal> getGoalById(@PathVariable Long id) {
        return goalService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Goal createGoal(@RequestBody Goal goal) {
        return goalService.save(goal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Goal> updateGoal(@PathVariable Long id, @RequestBody Goal goal) {
        goal.setId(id);
        return ResponseEntity.ok(goalService.save(goal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoal(@PathVariable Long id) {
        goalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
