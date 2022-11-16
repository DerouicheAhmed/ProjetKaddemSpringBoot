package com.example.springprojetkaddem.kaddem.controller;

import com.example.springprojetkaddem.kaddem.services.DepartementServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.springprojetkaddem.kaddem.entity.Departement;

import java.util.List;

@RequestMapping("/depart")
@RestController
public class DepartementController {
    @Autowired
    DepartementServiceInterface departementServiceInterface;

    @GetMapping()
    public List<Departement> retrieveAllDepartements(){
        return departementServiceInterface.retrieveAllDepartements();
    }

    @PostMapping("/add")
    public Departement addDepartement (@RequestBody Departement dep){
        return departementServiceInterface.addDepartement(dep);
    }

    @PutMapping("/edit")
    public Departement updateDepartement (@RequestBody Departement dep){
        return departementServiceInterface.updateDepartement(dep);
    }

    @GetMapping("/{idDepart}")
    public Departement retrieveDepartement (@PathVariable Integer idDepart){
        return departementServiceInterface.retrieveDepartement(idDepart);
    }
}
