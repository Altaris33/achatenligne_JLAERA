package com.achatenligne.web.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.achatenligne.model.Produit;
import com.achatenligne.model.ProduitService;

@Path("/listeProduits")
public class ListeProduitsResource {

	@GET 
	@Produces({"application/json", "application/xml"})
	public List<Produit> getAll(){
		ProduitService produit1 = new ProduitService();
		List<Produit> list = new ArrayList<Produit>();
		list = produit1.getAll();
		return list; 
	}
	
	/*@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createProduct(@PathParam("id")Produit produit, @Context UriInfo uriInfo) throws URISyntaxException {
		//on souhaite créer et ajouter un nouveau produit
		//int id = 664455;
		ProduitService prod = new ProduitService();
		prod.createProduct(produit);
		URI uri = uriInfo.getRequestUriBuilder().path(String.valueOf(prod)).build();
		return Response.created(uri)
				.header("allow", "GET, OPTIONS")
				.entity(prod)
				.build(); 
	}*/
	
}
