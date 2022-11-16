package com.example.springprojetkaddem.kaddem.services;

import com.example.springprojetkaddem.kaddem.entity.Departement;

import java.util.List;

public interface DepartementServiceInterface {
    List<Departement> retrieveAllDepartements();

    Departement addDepartement (Departement dep);

    Departement updateDepartement (Departement dep);

    Departement retrieveDepartement (Integer idDepart);
}
