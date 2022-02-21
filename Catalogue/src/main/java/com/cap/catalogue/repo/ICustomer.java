package com.cap.catalogue.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.cap.catalogue.entities.Categorie;

@RepositoryRestResource(collectionResourceRel = "catalogues", itemResourceRel = "cat")
public interface ICustomer extends JpaRepository<Categorie, Long>{

	@RestResource(path = "bylib", rel = "findbylibe")
	public Categorie findByLibelle(String lib);
	
	@RestResource(exported = false)
	public void deleteById(long id);
	
	
}
