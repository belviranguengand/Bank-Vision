package com.demo.Projet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.Projet.model.Transaction;


public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
