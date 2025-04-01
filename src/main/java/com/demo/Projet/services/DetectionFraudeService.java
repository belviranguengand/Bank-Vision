package com.demo.Projet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Projet.model.DetectionFraude;
import com.demo.Projet.repositories.DetectionFraudeRepository;

import jakarta.transaction.Transactional;

@Service
public class DetectionFraudeService {

    @Autowired
    private DetectionFraudeRepository detectionFraudeRepository;

    public List<DetectionFraude> getAllFraudes() {
        return detectionFraudeRepository.findAll();
    }

    public Optional<DetectionFraude> getFraudeById(Long id) {
        return detectionFraudeRepository.findById(id);
    }

    @Transactional
    public DetectionFraude saveFraude(DetectionFraude fraude) {
        return detectionFraudeRepository.save(fraude);
    }

    public void deleteFraude(Long id) {
        detectionFraudeRepository.deleteById(id);
    }

    public DetectionFraude updateNiveauRisque(Long id, String niveauRisque, String commentaire) {
        Optional<DetectionFraude> fraudeOpt = detectionFraudeRepository.findById(id);
        if (fraudeOpt.isPresent()) {
            DetectionFraude fraude = fraudeOpt.get();
            fraude.setNiveauRisque(niveauRisque);
            fraude.setCommentaire(commentaire);
            return detectionFraudeRepository.save(fraude);
        } else {
            throw new RuntimeException("Détection de fraude non trouvée avec l'ID : " + id);
        }
    }
}