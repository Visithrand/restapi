package com.example.demo.repositories;

import com.example.demo.entities.CommunityGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityGroupRepository extends JpaRepository<CommunityGroup, Long> {
    // Additional query methods can be defined here
}
