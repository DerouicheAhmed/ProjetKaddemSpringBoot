package com.example.springprojetkaddem.kaddem.services;

import com.example.springprojetkaddem.kaddem.entity.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import com.example.springprojetkaddem.kaddem.entity.Contrat;
import com.example.springprojetkaddem.kaddem.respository.ContratRepository;
import com.example.springprojetkaddem.kaddem.respository.EtudiantRepository;

import java.util.List;
import java.util.Set;

@Service
public class ContratServiceImplemt implements ContratServiceInterface{
    @Autowired
    ContratRepository contratRepository;
    EtudiantRepository etudiantRepository;
    @Override
    public List<Contrat> retrieveAllContrats() {
        return  contratRepository.findAll();
    }

    @Override
    public Contrat updateContrat(Contrat contrat) {
        try {
            Contrat c=contratRepository.findById(contrat.getIdContrat()).get();
            return contratRepository.save(contrat);
        } catch (Exception E) {
            System.out.println("Erreur : " + E);

        }
        return contrat;
    }

    @Override
    public Contrat addContrat(Contrat contrat) {
        try {
            return contratRepository.save(contrat);
        } catch (Exception E) {
            System.out.println("Erreur : " + E);
        }
        return contrat;
    }

    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        try {
            return contratRepository.findById(idContrat).orElse(null);
        } catch (Exception E) {
            System.out.println("Erreur : " + E);
        }
        return contratRepository.findById(idContrat).orElse(null);
    }

    @Override
    public void removeContrat(Integer idContrat) {
        try {
            Contrat contrat=contratRepository.findById(idContrat).orElseThrow(ChangeSetPersister.NotFoundException::new);
            contratRepository.delete(contrat);
        } catch (Exception err) {
            System.out.println("Erreur : " + err);
        }
    }

    @Override
    public Contrat affecterContratToEtudiant(Contrat c, String nomE, String prenomE) {
        int nbContratsvalides=contratRepository.countByArchiveIsFalseAndEtudiant_NomEAndEtudiant_PrenomE(nomE,prenomE);
        if (nbContratsvalides<5){
            Contrat contrat=this.retrieveContrat(c.getIdContrat());
            Etudiant etudiant=etudiantRepository.findByNomEAndPrenomE(nomE,prenomE);
            c.setEtudiant(etudiant);
            this.updateContrat(c);
            return this.retrieveContrat(c.getIdContrat());
        }else {
            return  null;
        }

    }

}
