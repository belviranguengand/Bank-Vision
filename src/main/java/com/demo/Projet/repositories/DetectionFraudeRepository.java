package com.demo.Projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.Projet.model.DetectionFraude;

public interface DetectionFraudeRepository extends JpaRepository<DetectionFraude, Long>{

}
