package com.achatenligne.web.resources;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.achatenligne.model.Produit;
import com.achatenligne.model.ProduitService;

@Path("/produit")
public class ProduitPostResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createProduct(Produit produit, @Context UriInfo uriInfo) {
		//on souhaite créer et ajouter un nouveau produit
		//int id = 664455;
		ProduitService prod = new ProduitService();
		prod.createProduct(produit);
		URI uri = uriInfo.getRequestUriBuilder()
				.build();
		return Response.created(uri)
				.header("allow", "GET, OPTIONS")
				.entity(prod)
				.build(); 
	}
	
	
}
