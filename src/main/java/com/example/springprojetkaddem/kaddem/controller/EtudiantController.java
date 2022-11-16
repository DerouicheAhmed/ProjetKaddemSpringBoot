package com.example.springprojetkaddem.kaddem.controller;

import com.example.springprojetkaddem.kaddem.entity.Etudiant;
import com.example.springprojetkaddem.kaddem.services.EtudiantServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/etud")
@RestController
public class EtudiantController {
    @Autowired
    protected EtudiantServiceInterface etudiantServiceInterface;
    @GetMapping()
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantServiceInterface.retrieveAllEtudiants();
    }


    @PostMapping("/add")
    Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return  etudiantServiceInterface.addEtudiant(etudiant);
    }

    @PutMapping("/edit")
    Etudiant updateEtudiant(@RequestBody Etudiant e) {
        return etudiantServiceInterface.updateEtudiant(e);
    }

    @GetMapping("/{id}")
    Etudiant retrieveEtudiant(@PathVariable Integer id) {
        return etudiantServiceInterface.retrieveEtudiant(id);
    }

    @DeleteMapping("/delete/{id}")
    void removeEtudiant(@PathVariable Integer id)
    {
        etudiantServiceInterface.removeEtudiant(id);
    }

    @GetMapping ("/assign/{etudiantId}/{departementId}")
    public Etudiant assignEtudiantToDepartement(@PathVariable Integer etudiantId,@PathVariable Integer departementId){

       return this.etudiantServiceInterface.assignEtudiantToDepartement( etudiantId,  departementId);

    }
    @PutMapping ("assignEq/{idContrat}/{idEquipe}")
    public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e, @PathVariable Integer idContrat,@PathVariable Integer idEquipe)
    {
        return   this.etudiantServiceInterface.addAndAssignEtudiantToEquipeAndContract(e,idContrat,idEquipe);
    }

}

