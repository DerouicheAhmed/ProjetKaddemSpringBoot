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
public class Equipe {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idEquipe")
    private int idEquipe;
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    @Column(name="Niveau")
    private Niveau niveau;
    @ManyToMany(mappedBy ="equipe")
    @JsonIgnoreProperties("equipe")
    private Set<Etudiant> etudiant;
    @OneToOne(mappedBy = "equipe")
    private DetailEquipe detailEquipe;
}
