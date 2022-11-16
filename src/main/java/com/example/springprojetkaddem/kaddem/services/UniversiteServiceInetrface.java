package com.example.springprojetkaddem.kaddem.services;

import com.example.springprojetkaddem.kaddem.entity.Universite;

import java.util.List;

public interface UniversiteServiceInetrface {
    List<Universite> retrieveAllUniversites();
    Universite addUniversite (Universite u);
    Universite updateUniversite (Universite u);
    Universite retrieveUniversite (Integer idUniversite);
    void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);
}
