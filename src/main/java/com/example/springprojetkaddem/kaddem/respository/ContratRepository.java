package com.example.springprojetkaddem.kaddem.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springprojetkaddem.kaddem.entity.Contrat;

public interface ContratRepository extends JpaRepository<Contrat,Integer> {
    public int countByArchiveIsFalseAndEtudiant_NomEAndEtudiant_PrenomE(String nomE,String prenomE);
}
