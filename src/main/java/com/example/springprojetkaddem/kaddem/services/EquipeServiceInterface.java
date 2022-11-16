package com.example.springprojetkaddem.kaddem.services;

import com.example.springprojetkaddem.kaddem.entity.Equipe;

import java.util.List;

public interface EquipeServiceInterface {
    List<Equipe> retrieveAllEquipes();

    Equipe addEquipe(Equipe equipe); // ajouter l’équipe avec son détail

    Equipe updateEquipe (Equipe equipe);

    Equipe retrieveEquipe (Integer idEquipe);
}
