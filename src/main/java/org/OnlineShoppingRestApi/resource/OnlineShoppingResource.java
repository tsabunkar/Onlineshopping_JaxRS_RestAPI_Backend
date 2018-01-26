package org.OnlineShoppingRestApi.resource;

import java.sql.SQLException;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Application;

import org.OnlineShoppingRestApi.dao.ProductRepoistry;
import org.OnlineShoppingRestApi.dao.ProductRepoistryImple;
import org.OnlineShoppingRestApi.dto.Product;

@Path("/productslist")
public class OnlineShoppingResource {

	ProductRepoistry prodRepo = new ProductRepoistryImple();
	
	//http://localhost:8081/OnlineShoppingRestApi/webapi/productslist
	@GET
	@Produces(MediaType.APPLICATION_JSON)	

	public List<Product> myGetAllProducts() throws ClassNotFoundException, SQLException{
	
		List<Product> listOfProducts =  prodRepo.getAllProduct();
		System.out.println("Get all method is invoked from Front-end");
		System.out.println("------------");
		for (Product prod : listOfProducts) {
			System.out.println(prod);
		}
		
		return listOfProducts;
	}
	
	

	@GET
	@Path("/{productId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getParticularMessage(@PathParam("productId") int id)
			throws NumberFormatException, ClassNotFoundException, SQLException {
		
		Product product =  prodRepo.getParticularProd(id);
		
		return product;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)

	public Product createProduct(Product product) throws ClassNotFoundException, SQLException{
		System.out.println("createProduct is invoked");
		int i = prodRepo.createProduct(product);
		String val = String.valueOf(i);
		System.out.println(val + " Record inserted Successfully !!");
		//return val + " Record inserted Successfully !!";
		if(val.equals("1"))
		return product;
		else
			return null;
	}
	
	
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{productId}")
	public String deleteMyProduct(@PathParam("productId") int id)
			throws NumberFormatException, ClassNotFoundException, SQLException {
	System.out.println(" delete method is invoked...");
	ProductRepoistry prodReop = 	new ProductRepoistryImple(); 
	return  	prodReop.removeProduct(id);
	//	return i +" record deleted...";

	}
	
	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{productId}")
	public String updateExistingMessage(@PathParam("productId") int id, Product prodWithOutIdProp)
			throws ClassNotFoundException, SQLException {
		System.out.println("id value is "+id);
		ProductRepoistry prodReop = 	new ProductRepoistryImple(); 
		return prodReop.updateProduct(id, prodWithOutIdProp);
	}
	 
	
	

}