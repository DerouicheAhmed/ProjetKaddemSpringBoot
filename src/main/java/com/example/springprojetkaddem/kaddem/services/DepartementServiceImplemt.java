package com.example.springprojetkaddem.kaddem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springprojetkaddem.kaddem.entity.Departement;
import com.example.springprojetkaddem.kaddem.respository.DepartementRepository;

import java.util.List;
@Service
public class DepartementServiceImplemt implements DepartementServiceInterface{
    @Autowired
    protected DepartementRepository departementRepository;
    @Override
    public List<Departement> retrieveAllDepartements() {
        return departementRepository.findAll();
    }

    @Override
    public Departement addDepartement(Departement dep) {
        try {
            return departementRepository.save(dep);
        } catch (Exception E) {
            System.out.println("Erreur  : " + E);
        }
        return dep;
    }

    @Override
    public Departement updateDepartement(Departement dep) {
        try {
            Departement departement=departementRepository.findById(dep.getIdDepart()).get();
            return departementRepository.save(dep);
        } catch (Exception E) {
            System.out.println("Erreur : " + E);
        }
        return dep;
    }

    @Override
    public Departement retrieveDepartement(Integer idDepart) {
        try {
            return departementRepository.findById(idDepart).get();
        } catch (Exception E) {
            System.out.println("Erreur : " + E);
        }
        return null;
    }
    }

