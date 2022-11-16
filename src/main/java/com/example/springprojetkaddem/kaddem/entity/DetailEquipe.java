package com.example.springprojetkaddem.kaddem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DetailEquipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetailEquipe;
    private int salle;
    private String thematique;
    @OneToOne
    @JoinColumn(name = "equipe_idEquipe", referencedColumnName = "idEquipe")
    private Equipe equipe;

}
