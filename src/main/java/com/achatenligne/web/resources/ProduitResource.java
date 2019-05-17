package com.achatenligne.web.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.achatenligne.model.Produit;
import com.achatenligne.model.ProduitService;

@Path("/produit/{id}")
public class ProduitResource {
	@GET 
	@Produces({"application/json", "application/xml"})
	public Produit getOne(@PathParam("id") int id){
		ProduitService prod = new ProduitService();
		return prod.returnOne(id).get();
	}
	 
	//Modification/Mise à jour de produits
	
	@PUT 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON) 
	public void update(Produit produit) {
		ProduitService prod = new ProduitService();
		prod.update(produit); 
		
	}
	
	//Suppression de produits
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void suppress(Produit produit) {
		ProduitService prod = new ProduitService();
		prod.suppress(produit.getId()); 
	}
}
