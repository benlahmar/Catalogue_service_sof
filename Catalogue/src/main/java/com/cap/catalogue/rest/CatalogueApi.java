package com.cap.catalogue.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cap.catalogue.entities.Categorie;
import com.cap.catalogue.entities.Produit;
import com.cap.catalogue.repo.ICategorie;
import com.cap.catalogue.repo.IProduit;

@RestController
public class CatalogueApi {

	@Autowired
	ICategorie crepo;
	@Autowired
	IProduit prepo;
	
	@PostMapping("/categories")
	public Categorie save(@RequestBody Categorie c)
	{
		
		return crepo.save(c);
	}
	
	
	@PostMapping("/categories/{idc}/prouits")
	public Produit savep(@RequestBody Produit p,@PathVariable long idc)
	{
		Optional<Categorie> co = crepo.findById(idc);
		Categorie c = co.get();
		p.setCategorie(c);
		
		//c.getProduits().add(p);
		
		return prepo.save(p);
	}
	
	@GetMapping("/categories")
	public List<Categorie> allcat()
	{
		return crepo.findAll();
	}
	
	@GetMapping("/categories/{idc}/produits")
	public Page<Produit> allpro(@PathVariable long idc,@RequestParam int page,@RequestParam int size)
	{
		Pageable p=PageRequest.of(page, size);
		Page<Produit> res = prepo.findByCategorieId(idc, p);
		return res;
	}
}
