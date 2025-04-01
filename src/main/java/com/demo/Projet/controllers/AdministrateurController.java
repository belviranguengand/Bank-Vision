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
import org.springframework.web.bind.annotation.RestController;

import com.demo.Projet.model.Administrateur;
import com.demo.Projet.services.AdministrateurService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/administrateurs")
public class AdministrateurController {

    @Autowired
    private AdministrateurService administrateurService;

    @GetMapping
    public List<Administrateur> getAllAdministrateurs() {
        return administrateurService.getAllAdministrateurs();
    }

    @GetMapping("/{id}")
    public Optional<Administrateur> getAdministrateurById(@PathVariable Long id) {
        return administrateurService.getAdministrateurById(id);
    }

    @PostMapping
    public Administrateur createAdministrateur(@RequestBody Administrateur administrateur) {
        return administrateurService.saveAdministrateur(administrateur);
    }

    @PutMapping("/{id}")
    public Administrateur updateAdministrateur(@PathVariable Long id, @RequestBody Administrateur newAdmin) {
        return administrateurService.updateAdministrateur(id, newAdmin);
    }

    @DeleteMapping("/{id}")
    public String deleteAdministrateur(@PathVariable Long id) {
        administrateurService.deleteAdministrateur(id);
        return "Administrateur supprimé avec succès.";
    }
}
