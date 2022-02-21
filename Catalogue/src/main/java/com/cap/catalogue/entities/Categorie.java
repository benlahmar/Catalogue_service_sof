package com.cap.catalogue.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
public class Categorie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String libelle;
	@JsonManagedReference
	@OneToMany(mappedBy = "categorie",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	List<Produit> produits=new ArrayList<>();
}
