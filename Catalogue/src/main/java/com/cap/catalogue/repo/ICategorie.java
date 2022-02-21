package com.cap.catalogue.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cap.catalogue.entities.Categorie;

public interface ICategorie extends JpaRepository<Categorie, Long>{

}
