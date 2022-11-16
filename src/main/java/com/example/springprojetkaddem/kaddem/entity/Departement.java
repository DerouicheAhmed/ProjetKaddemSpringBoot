package com.example.springprojetkaddem.kaddem.entity;

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
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDepart;
    private String nomDepart;


    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
   // @JsonIgnoreProperties("departement")
    private Set<Etudiant> etudiants;
}
