package com.cap.catalogue.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String desg;
	
	double price;
	
	@ManyToOne()
	@JsonBackReference
	Categorie categorie;
	
}
