package com.demo.Projet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Projet.model.Administrateur;
import com.demo.Projet.repositories.AdministrateurRepository;

import jakarta.transaction.Transactional;

@Service
public class AdministrateurService {

    @Autowired
    private AdministrateurRepository administrateurRepository;

    public List<Administrateur> getAllAdministrateurs() {
        return administrateurRepository.findAll();
    }

    public Optional<Administrateur> getAdministrateurById(Long id) {
        return administrateurRepository.findById(id);
    }

    @Transactional
    public Administrateur saveAdministrateur(Administrateur administrateur) {
        return administrateurRepository.save(administrateur);
    }

    public void deleteAdministrateur(Long id) {
        administrateurRepository.deleteById(id);
    }

    public Administrateur updateAdministrateur(Long id, Administrateur newAdmin) {
        return administrateurRepository.findById(id).map(admin -> {
            admin.setNom(newAdmin.getNom());
            admin.setEmail(newAdmin.getEmail());
            admin.setMotDePasse(newAdmin.getMotDePasse());
            return administrateurRepository.save(admin);
        }).orElseThrow(() -> new RuntimeException("Administrateur non trouvé avec l'ID : " + id));
    }
}
