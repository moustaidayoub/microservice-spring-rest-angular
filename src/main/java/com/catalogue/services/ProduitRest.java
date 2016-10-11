package com.catalogue.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalogue.dao.IProduitRepository;
import com.catalogue.entities.Produit;

@RestController
@RequestMapping("/produits")
public class ProduitRest {
	@Autowired
	private IProduitRepository produitRepository;

	@RequestMapping(method = RequestMethod.POST)
	public Produit saveProduit(Produit p) {
		produitRepository.save(p);
		return p;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Produit> getProduits() {
		return produitRepository.findAll();
	}

	@RequestMapping(value = "/{page}", method = RequestMethod.GET)
	public Page<Produit> getProduits(@PathVariable int page) {
		return produitRepository.findAll(new PageRequest(page, 5));
	}

	@RequestMapping(value = "/produitsParMC", method = RequestMethod.GET)
	public Page<Produit> getProduits(String mc, int page) {
		return produitRepository.produitParMC(mc, new PageRequest(page, 3));
	}

	@RequestMapping("/findone/{ref}")
	public Produit getProduit(@PathVariable Long ref) {
		return produitRepository.findOne(ref);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public boolean delete(Long ref) {
		produitRepository.delete(ref);
		return true;
	}

}
