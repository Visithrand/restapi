package com.example.demo.controllers;

import com.example.demo.entities.Speech;
import com.example.demo.services.SpeechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/speeches")
public class SpeechController {
    @Autowired
    private SpeechService speechService;

    @GetMapping
    public List<Speech> getAllSpeeches() {
        return speechService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Speech> getSpeechById(@PathVariable Long id) {
        return speechService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Speech createSpeech(@RequestBody Speech speech) {
        return speechService.save(speech);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Speech> updateSpeech(@PathVariable Long id, @RequestBody Speech speech) {
        speech.setId(id);
        return ResponseEntity.ok(speechService.save(speech));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpeech(@PathVariable Long id) {
        speechService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
