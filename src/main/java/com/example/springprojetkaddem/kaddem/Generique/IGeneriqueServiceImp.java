package com.example.springprojetkaddem.kaddem.Generique;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class IGeneriqueServiceImp<T,ID> implements IGeneriqueService <T,ID>{


    @Autowired
    JpaRepository<T,ID> repository;

    @Override
    public List<T> retrieveAll() {
        return repository.findAll();
    }



    @Override
    public T add(T entity) {
        return repository.save(entity);
    }

    @Override
    public T retrieve(ID i) {
        try {
            return repository.findById(i).orElse(null);
        } catch (Exception E) {
            System.out.println("Erreur : " + E);
        }
        return repository.findById(i).orElse(null);
    }

    @Override
    public void remove(ID id) {
        repository.deleteById(id);

    }
}
