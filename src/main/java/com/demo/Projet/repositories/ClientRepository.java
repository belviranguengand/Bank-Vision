package com.demo.Projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.Projet.model.Client;


public interface ClientRepository extends JpaRepository<Client, Long> {

}
