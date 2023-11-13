package com.asma.parfums.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.asma.parfums.entities.Marque;


@RepositoryRestResource(path = "marq")
@CrossOrigin("http://localhost:4200/") 
public interface MarqueRepository extends JpaRepository<Marque, Long>{

}
