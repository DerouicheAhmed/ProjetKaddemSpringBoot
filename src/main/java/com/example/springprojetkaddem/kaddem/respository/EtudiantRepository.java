package com.example.springprojetkaddem.kaddem.respository;

import com.example.springprojetkaddem.kaddem.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {
   public List<Etudiant> findEtudiantByNomE(String nomE);
    public Etudiant findByNomEAndPrenomE(String nomE, String prenomE);
    public List<Etudiant> findEtudiantByDepartment_IdDepart(Integer idDepart);
}
