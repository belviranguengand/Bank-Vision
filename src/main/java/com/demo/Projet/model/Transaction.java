package com.demo.Projet.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double montant;
    private String type;
    private String statut;
    
    @ManyToOne
    @JoinColumn(name = "compte_id")
    private Compte compte;
    
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Administrateur validePar;
    
    @OneToOne(mappedBy = "transaction")
    private DetectionFraude detectionFraude;
}