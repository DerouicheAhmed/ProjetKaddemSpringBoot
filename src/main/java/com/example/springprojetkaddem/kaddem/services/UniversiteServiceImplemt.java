package com.example.springprojetkaddem.kaddem.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.springprojetkaddem.kaddem.entity.Departement;
import com.example.springprojetkaddem.kaddem.entity.Universite;
import com.example.springprojetkaddem.kaddem.respository.DepartementRepository;
import com.example.springprojetkaddem.kaddem.respository.UniversiteRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class UniversiteServiceImplemt implements UniversiteServiceInetrface {

    protected UniversiteRepository universiteRepository;
    DepartementRepository departementRepository;
    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        try {
            return universiteRepository.save(u);
        } catch (Exception E) {
            System.out.println("Erreur : " + E);
        }
        return u;
    }

    @Override
    public Universite updateUniversite(Universite u) {
        try {
            Universite universite=universiteRepository.findById(u.getIdUniv()).get();
            return universiteRepository.save(u);
        } catch (Exception E) {
            System.out.println("Erreur : " + E);
        }
        return u;
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        try {
            return universiteRepository.findById(idUniversite).get();
        } catch (Exception E) {
            System.out.println("Erreur : " + E);
        }
        return null;
    }

    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        System.out.println("U1");
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
        System.out.println("U2");
        Departement departement=departementRepository.findById(idDepartement).orElse(null);
        universite.getDepartement().add(departement);
        System.out.println("U3");
        this.universiteRepository.save(universite);

    }
}
