package com.example.springprojetkaddem.kaddem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Etudiant  {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Option options;
    @ManyToOne
    @JsonIgnoreProperties("etudiants")
    private Departement department;
    @ManyToMany
    @JsonIgnoreProperties("etudiant")
    private Set<Equipe> equipe;
    @OneToMany(mappedBy = "etudiant",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("etudiant")
    private Set<Contrat> contrats;
}
