package com.demo.Projet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Projet.model.Compte;
import com.demo.Projet.repositories.CompteRepository;

import jakarta.transaction.Transactional;

@Service
public class CompteService {

    @Autowired
    private CompteRepository compteRepository;

    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }

    public Optional<Compte> getCompteById(Long id) {
        return compteRepository.findById(id);
    }

    @Transactional
    public Compte saveCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    public void deleteCompte(Long id) {
        compteRepository.deleteById(id);
    }

    public Compte updateSoldeCompte(Long id, double newSolde) {
        Optional<Compte> compteOpt = compteRepository.findById(id);
        if (compteOpt.isPresent()) {
            Compte compte = compteOpt.get();
            compte.setSolde(newSolde);
            return compteRepository.save(compte);
        } else {
            throw new RuntimeException("Compte non trouvé avec l'ID : " + id);
        }
    }


}
