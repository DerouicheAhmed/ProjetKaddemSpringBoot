package com.example.springprojetkaddem.kaddem.services;

import com.example.springprojetkaddem.kaddem.entity.Etudiant;

import java.util.List;

public interface EtudiantServiceInterface {
    List<Etudiant> retrieveAllEtudiants();

    Etudiant addEtudiant (Etudiant e);

    Etudiant updateEtudiant (Etudiant e);

    Etudiant retrieveEtudiant(Integer idEtudiant);

    void removeEtudiant(Integer idEtudiant);

    Etudiant assignEtudiantToDepartement (Integer etudiantId, Integer departementId) ;

    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe);
}
