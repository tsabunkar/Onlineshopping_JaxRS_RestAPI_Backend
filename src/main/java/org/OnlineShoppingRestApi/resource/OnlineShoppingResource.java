package org.OnlineShoppingRestApi.resource;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.OnlineShoppingRestApi.dao.ProductRepoistry;
import org.OnlineShoppingRestApi.dao.ProductRepoistryImple;
import org.OnlineShoppingRestApi.dto.Product;

@Path("/productslist")
public class OnlineShoppingResource {

	ProductRepoistry prodRepo = new ProductRepoistryImple();
	@GET
	@Produces(MediaType.APPLICATION_JSON)	//http://localhost:8080/ActivityProj/webapi/activities
	public List<Product> myGetAllProducts() throws ClassNotFoundException, SQLException{
	
		List<Product> listOfProducts =  prodRepo.getAllProduct();
		System.out.println("Get all method is invoked from Front-end");
		System.out.println("------------");
		for (Product prod : listOfProducts) {
			System.out.println(prod);
		}
		
		return listOfProducts;
	}
}
