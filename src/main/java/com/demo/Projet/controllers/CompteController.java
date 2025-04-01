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

import com.demo.Projet.model.Compte;
import com.demo.Projet.services.CompteService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/comptes")
public class CompteController {

    @Autowired
    private CompteService compteService;

    @GetMapping
    public List<Compte> getAllComptes() {
        return compteService.getAllComptes();
    }

    @GetMapping("/{id}")
    public Optional<Compte> getCompteById(@PathVariable Long id) {
        return compteService.getCompteById(id);
    }

    @PostMapping
    public Compte createCompte(@RequestBody Compte compte) {
        return compteService.saveCompte(compte);
    }

    @PutMapping("/{id}/solde")
    public Compte updateSoldeCompte(@PathVariable Long id, @RequestParam double solde) {
        return compteService.updateSoldeCompte(id, solde);
    }

    @DeleteMapping("/{id}")
    public String deleteCompte(@PathVariable Long id) {
        compteService.deleteCompte(id);
        return "Compte supprimé avec succès.";
    }
}