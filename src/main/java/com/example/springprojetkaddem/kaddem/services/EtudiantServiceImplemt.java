package com.example.springprojetkaddem.kaddem.services;

import com.example.springprojetkaddem.kaddem.entity.Etudiant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.springprojetkaddem.kaddem.entity.Contrat;
import com.example.springprojetkaddem.kaddem.entity.Departement;
import com.example.springprojetkaddem.kaddem.entity.Equipe;
import com.example.springprojetkaddem.kaddem.respository.ContratRepository;
import com.example.springprojetkaddem.kaddem.respository.DepartementRepository;
import com.example.springprojetkaddem.kaddem.respository.EquipeRepository;
import com.example.springprojetkaddem.kaddem.respository.EtudiantRepository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class EtudiantServiceImplemt implements EtudiantServiceInterface{
    protected EtudiantRepository etudiantRepository;
    EquipeRepository equipeRepository;
    private DepartementRepository departementRepository;
    private ContratRepository contratRepository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        try {
            return etudiantRepository.save(e);
        } catch (Exception E) {
            System.out.println("Erreur : " + E);
        }
        return e;
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        try {
            Etudiant etudiant=etudiantRepository.findById(e.getId()).get();
            return etudiantRepository.save(e);
        } catch (Exception E) {
            System.out.println("Erreur : " + E);
        }
        return null;
    }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant) {
        try {
            return etudiantRepository.findById(idEtudiant).get();
        } catch (Exception E) {
            System.out.println("Erreur : " + E);
        }
        return null;
    }

    @Override
    public void removeEtudiant(Integer idEtudiant) {
        try {
            Etudiant etudiant=etudiantRepository.findById(idEtudiant).get();
            etudiantRepository.delete(etudiant);
        } catch (Exception E) {
            System.out.println("Erreur : " + E);
        }

    }

    @Override
    public Etudiant assignEtudiantToDepartement(Integer etudiantId, Integer departementId) {
        /*recuperation des objet*/
        Etudiant etudiant = etudiantRepository.findById(etudiantId).orElse(null);
        Departement departement = departementRepository.findById(departementId).orElse(null);
        /*verification*/
        if (etudiant!=null && departement!=null){
            /*treatement*/
            etudiant.setDepartment(departement);
            /*save*/
           return etudiantRepository.save(etudiant);
        }
return null;
    }

   @Override
   @Transactional
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
      Contrat  contrat=contratRepository.findById(idContrat).orElse(null);
      Equipe equipe=equipeRepository.findById(idEquipe).orElse(null);
      if (contrat!=null && equipe!=null){
          Etudiant etudiant=new Etudiant();
          Set<Equipe> equipes =new HashSet<>();
          etudiant.setEquipe(equipes);
          etudiantRepository.save(e);
          etudiant.getEquipe().add(equipe);
          contrat.setEtudiant(etudiant);
          return etudiant;

      }

        //Methode 1:
     /*   Contrat contrat = contratRepository.findById(idContrat).orElse(null);
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);

        if(contrat!=null && equipe!=null) {
            e.getEquipe().add(equipe);
            e.getContrats().add(contrat);
            contrat.setEtudiant(e);
            contratRepository.save(contrat);
            etudiantRepository.save(e);
        }*/
        return e;

    }

 public   List<Etudiant> getEtudiantsByDepartement (Integer idDepartement){
        return  etudiantRepository.findEtudiantByDepartment_IdDepart(idDepartement);
 }

}
