package com.example.springprojetkaddem.kaddem.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springprojetkaddem.kaddem.entity.Departement;

public interface DepartementRepository  extends JpaRepository<Departement,Integer> {
}
