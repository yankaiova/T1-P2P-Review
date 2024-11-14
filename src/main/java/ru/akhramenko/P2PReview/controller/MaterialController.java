package ru.akhramenko.P2PReview.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.akhramenko.P2PReview.entity.User;
import ru.akhramenko.P2PReview.service.UserService;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/materials")
public class MaterialController {

    private final MaterialService materialService;

    @GetMapping("/{id}")
    public Material getMaterialById(@PathVariable UUID id) {
        return materialService.findById(id);
    }

    @GetMapping("/meeting_id={meeting_id}")
    @Operation(summary = "Получение материала по id встречи")
    public List<Material> findAllMaterialsByMeeting(@RequestParam UUID meeting_id) {
        return materialService.findByMeeting(meeting_ID);
    }


    @PostMapping("")
    public Material addNewMaterial(@RequestBody Material material) {
        return materialService.create(material);
    }

    @DeleteMapping("/{id}")
    public void deleteMaterialById(@PathVariable UUID id) {
        materialService.delete(id);
    }

}