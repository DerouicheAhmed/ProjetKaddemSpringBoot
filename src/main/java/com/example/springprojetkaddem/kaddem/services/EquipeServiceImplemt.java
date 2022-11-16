package com.example.springprojetkaddem.kaddem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springprojetkaddem.kaddem.entity.Equipe;
import com.example.springprojetkaddem.kaddem.respository.EquipeRepository;

import java.util.List;
@Service
public class EquipeServiceImplemt implements EquipeServiceInterface{
    @Autowired
 protected EquipeRepository repository;
    @Override
    public List<Equipe> retrieveAllEquipes() {
        return repository.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe equipe) {
        try {
            return repository.save(equipe);
        } catch (Exception E) {
            System.out.println("Erreur  : " + E);
        }
        return equipe;
    }

    @Override
    public Equipe updateEquipe(Equipe eq) {
        try {
            Equipe equipe=repository.findById(eq.getIdEquipe()).get();
            return repository.save(eq);
        } catch (Exception E) {
            System.out.println("Erreur : " + E);
        }
        return eq;
    }

    @Override
    public Equipe retrieveEquipe(Integer idEquipe) {
        try {
            return repository.findById(idEquipe).orElse(null);
        } catch (Exception E) {
            System.out.println("Erreur : " + E);
        }
        return null;

    }
    }

