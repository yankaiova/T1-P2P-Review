package ru.akhramenko.P2PReview.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.akhramenko.P2PReview.entity.Material;
import ru.akhramenko.P2PReview.repo.MaterialRepo;
import ru.akhramenko.P2PReview.utils.exeption.ResourceNotFoundException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MaterialService {

    private final MaterialRepo materialRepo;

    public Material findById(UUID id) {
        return materialRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional
    public Material create(Material material) {
        User createdMaterial = new Material();
        createdMaterial.setMaterial_id(UUID.randomUUID());
        createdMaterial.setMaterial_link(material.getLink());
        return materialRepo.save(createdMaterial);
    }

   @Transactional
   public List<Material> findByMeeting(UUID meeting_id) {
       return materialRepo.findByMeetingId(meeting_id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional
    public void delete(UUID id) {
        Material material = materialRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        materialRepo.delete(material);
    }
}