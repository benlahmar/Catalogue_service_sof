package com.cap.catalogue.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cap.catalogue.entities.Produit;

public interface IProduit  extends JpaRepository<Produit, Long>{

	public Page<Produit> findByCategorieId(long idc, Pageable p);
}
