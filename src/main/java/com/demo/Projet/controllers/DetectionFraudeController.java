package com.demo.Projet.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Projet.model.DetectionFraude;
import com.demo.Projet.services.DetectionFraudeService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/fraudes")
public class DetectionFraudeController {

    @Autowired
    private DetectionFraudeService detectionFraudeService;

    @GetMapping
    public List<DetectionFraude> getAllFraudes() {
        return detectionFraudeService.getAllFraudes();
    }

    @GetMapping("/{id}")
    public Optional<DetectionFraude> getFraudeById(@PathVariable Long id) {
        return detectionFraudeService.getFraudeById(id);
    }

    @PostMapping
    public DetectionFraude createFraude(@RequestBody DetectionFraude fraude) {
        return detectionFraudeService.saveFraude(fraude);
    }

    @PutMapping("/{id}")
    public DetectionFraude updateNiveauRisque(@PathVariable Long id, 
                                              @RequestParam String niveauRisque, 
                                              @RequestParam String commentaire) {
        return detectionFraudeService.updateNiveauRisque(id, niveauRisque, commentaire);
    }

    @DeleteMapping("/{id}")
    public String deleteFraude(@PathVariable Long id) {
        detectionFraudeService.deleteFraude(id);
        return "Détection de fraude supprimée avec succès.";
    }


}
