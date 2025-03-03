package com.example.demo.controllers;

import com.example.demo.entities.CommunityGroup;
import com.example.demo.services.CommunityGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/community-groups")
public class CommunityGroupController {
    @Autowired
    private CommunityGroupService communityGroupService;

    @GetMapping
    public List<CommunityGroup> getAllCommunityGroups() {
        return communityGroupService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommunityGroup> getCommunityGroupById(@PathVariable Long id) {
        return communityGroupService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CommunityGroup createCommunityGroup(@RequestBody CommunityGroup communityGroup) {
        return communityGroupService.save(communityGroup);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommunityGroup> updateCommunityGroup(@PathVariable Long id, @RequestBody CommunityGroup communityGroup) {
        communityGroup.setId(id);
        return ResponseEntity.ok(communityGroupService.save(communityGroup));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommunityGroup(@PathVariable Long id) {
        communityGroupService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
