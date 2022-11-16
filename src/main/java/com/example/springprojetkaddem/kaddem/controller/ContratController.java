package com.example.springprojetkaddem.kaddem.controller;

import com.example.springprojetkaddem.kaddem.respository.ContratRepository;
import com.example.springprojetkaddem.kaddem.respository.EtudiantRepository;
import com.example.springprojetkaddem.kaddem.services.ContratServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.springprojetkaddem.kaddem.entity.Contrat;

import java.util.List;

@RequestMapping("/contrat")
@RestController
public class ContratController {
    @Autowired
    ContratServiceInterface contratServiceInterface;
    EtudiantRepository etudiantRepository;
    ContratRepository contratRepository;
    @GetMapping()
    public List<Contrat> retrieveAllContrats(){
        return contratServiceInterface.retrieveAllContrats();
    }

    @PutMapping("/edit")
    public Contrat updateContrat (@RequestBody Contrat c){
        return contratServiceInterface.updateContrat(c);
    }

    @PostMapping("/add")
    public Contrat addContrat (@RequestBody Contrat c){
        return contratServiceInterface.addContrat(c);
    }

    @GetMapping("/{idContrat}")
    public Contrat retrieveContrat (@PathVariable Integer idContrat){
        return contratServiceInterface.retrieveContrat(idContrat);
    }

    @DeleteMapping("/delete/{idContrat}")
    public void removeContrat(@PathVariable Integer idContrat){
        contratServiceInterface.removeContrat(idContrat);
    }

    @PutMapping("/affectToEtudiant/{nomE}/{prenomE}")
    public  Contrat affectContratToEtudiant (@RequestBody Contrat c,@PathVariable("nomE") String nomE,@PathVariable("prenomE") String prenomE){
        return contratServiceInterface.affecterContratToEtudiant(c,nomE,prenomE);


    }
}
