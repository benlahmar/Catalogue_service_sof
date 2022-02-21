package com.cap.catalogue.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Categorie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String libelle;
	
	@OneToMany(mappedBy = "categorie")
	List<Produit> produits=new ArrayList<>();
}
