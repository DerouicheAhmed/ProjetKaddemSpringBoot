package com.example.springprojetkaddem.kaddem.controller;

import com.example.springprojetkaddem.kaddem.services.UniversiteServiceInetrface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.springprojetkaddem.kaddem.entity.Universite;

import java.util.List;

@RequestMapping("/universite")
@RestController
public class UniversiteController {
    @Autowired
    UniversiteServiceInetrface universiteServiceInetrface;
    @GetMapping()
    public List<Universite> retrieveAllUniversites(){
        return universiteServiceInetrface.retrieveAllUniversites();
    }

    @PostMapping("/add")
    public Universite addUniversite (@RequestBody Universite u){
        return universiteServiceInetrface.addUniversite(u);
    }

    @PutMapping("/edit")
    public  Universite updateUniversite (@RequestBody Universite u){
        return universiteServiceInetrface.updateUniversite(u);
    }

    @GetMapping("/{idUniversite}")
    public  Universite retrieveUniversite (@PathVariable Integer idUniversite){
        return universiteServiceInetrface.retrieveUniversite(idUniversite);
    }
    @PutMapping("/assign/{idUniversite}/{idDepartement}")
    public void assignUniversiteToDepartement(@PathVariable Integer idUniversite,@PathVariable Integer idDepartement)
    {
        this.universiteServiceInetrface.assignUniversiteToDepartement(idUniversite,idDepartement);
    }

}
