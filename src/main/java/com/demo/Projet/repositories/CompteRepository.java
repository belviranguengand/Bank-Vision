package com.demo.Projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.Projet.model.Compte;



public interface CompteRepository extends JpaRepository<Compte, Long>{

}
