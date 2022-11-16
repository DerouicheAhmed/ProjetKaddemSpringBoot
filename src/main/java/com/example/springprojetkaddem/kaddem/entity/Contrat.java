package com.example.springprojetkaddem.kaddem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Contrat {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int idContrat;
    @Temporal(TemporalType.DATE)
    private Date dateDebutContrat;
    @Temporal(TemporalType.DATE)
    private Date dateFinContrat;
    @Enumerated(EnumType.ORDINAL)
    private Specialite specialite;
    private boolean archive;
    private int montantContrat;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("contrats")

    private Etudiant etudiant;
}
