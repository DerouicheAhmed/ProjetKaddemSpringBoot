package com.example.springprojetkaddem.kaddem.Generique;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface RepositoryGenerique<T,ID> extends JpaRepository<T,ID> {
}
