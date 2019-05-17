package com.achatenligne.model;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;

import com.achatenligne.dao.ProduitDao;

public class ProduitService {
	
	public List<Produit> getAll() {
		ProduitDao produitDao = new ProduitDao();
		return produitDao.getAll();
	}
	
	public Optional<Produit> returnOne(int id) throws NotFoundException {
		ProduitDao produitDao = new ProduitDao();
		if( produitDao.getById(id).isPresent()){
			return produitDao.getById(id);
		}else {
			throw new NotFoundException();
		}
	}
	
	//création de produit
	public void createProduct(Produit produit) {
		ProduitDao produitDao = new ProduitDao();
		produitDao.create(produit);
	}

	public Commande creerCommande(int...idProduits) {
		Commande commande = new Commande();
		for (int idProduit : idProduits) {
			ajouter(commande, idProduit);
		}
		return commande;
	}
	
	//on doit vérifier si tous les champs sont renseignés et correspondent à la BDD
	public void update(Produit produit) {
		ProduitDao produitDao = new ProduitDao();
		if(produit.getCode() != null || produit.getLibelle() != null || produit.getPrix() != null) {
			produitDao.update(produit); 
		}else {
			throw new BadRequestException(); 
		}
		
	}
	
	
	//suppression de produit 
	public void suppress(int id) {
		ProduitDao produitDao = new ProduitDao();
		produitDao.delete(id);
	}

	private void ajouter(Commande commande, int idProduit) {
		ProduitDao produitDao = new ProduitDao();
		Optional<Produit> produit = produitDao.getById(idProduit);
		
		if (produit.isPresent()) {
			commande.add(produit.get());
		}
	}
}
