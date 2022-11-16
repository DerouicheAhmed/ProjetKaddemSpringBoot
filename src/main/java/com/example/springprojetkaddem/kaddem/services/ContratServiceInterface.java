package com.example.springprojetkaddem.kaddem.services;

import com.example.springprojetkaddem.kaddem.entity.Contrat;

import java.util.List;

public interface ContratServiceInterface {
    List<Contrat> retrieveAllContrats();

    Contrat updateContrat (Contrat contrat);

    Contrat addContrat (Contrat contrat);

    Contrat retrieveContrat (Integer idContrat);

    void removeContrat(Integer idContrat);

    Contrat affecterContratToEtudiant (Contrat contrat,String nomE,String prenomE);
}
