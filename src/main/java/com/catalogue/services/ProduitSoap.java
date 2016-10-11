package com.catalogue.services;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.catalogue.dao.IProduitRepository;
import com.catalogue.entities.Produit;

@Component
@WebService
public class ProduitSoap {
	@Autowired
	private IProduitRepository produitRepository;
	@WebMethod(operationName="saveProduit")
	public Produit saveProduit(@WebParam(name="des")String des,
			                   @WebParam(name="prix")double prix){
		Produit p=new Produit(des,prix);
		produitRepository.save(p);
		return p;
	}
	@WebMethod
	public List<Produit> listProduits(){
		return produitRepository.findAll();
	}
	@WebMethod
	public Produit getProduit(@WebParam(name="id")Long id){
		return produitRepository.findOne(id);
		
	}

	
}


