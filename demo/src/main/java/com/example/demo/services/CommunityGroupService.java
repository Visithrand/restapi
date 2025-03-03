package com.example.demo.services;

import com.example.demo.entities.CommunityGroup;
import com.example.demo.repositories.CommunityGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommunityGroupService {
    @Autowired
    private CommunityGroupRepository communityGroupRepository;

    public List<CommunityGroup> findAll() {
        return communityGroupRepository.findAll();
    }

    public Optional<CommunityGroup> findById(Long id) {
        return communityGroupRepository.findById(id);
    }

    public CommunityGroup save(CommunityGroup communityGroup) {
        return communityGroupRepository.save(communityGroup);
    }

    public void deleteById(Long id) {
        communityGroupRepository.deleteById(id);
    }
}
