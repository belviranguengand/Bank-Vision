package com.demo.Projet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Projet.model.Client;
import com.demo.Projet.repositories.ClientRepository;


@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;

    // Récupérer tous les clients
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Récupérer un client par son ID
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    // Ajouter un nouveau client
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    // Mettre à jour un client existant
    public Client updateClient(Long id, Client clientDetails) {
        return clientRepository.findById(id).map(client -> {
            client.setNom(clientDetails.getNom());
            client.setEmail(clientDetails.getEmail());
            client.setMotDePasse(clientDetails.getMotDePasse());
            return clientRepository.save(client);
        }).orElseThrow(() -> new RuntimeException("Client non trouvé avec l'ID : " + id));
    }

    // Supprimer un client
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}