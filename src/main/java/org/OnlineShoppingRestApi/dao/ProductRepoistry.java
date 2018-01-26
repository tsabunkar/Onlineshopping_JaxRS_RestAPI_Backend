package org.OnlineShoppingRestApi.dao;

import java.sql.SQLException;
import java.util.List;

import org.OnlineShoppingRestApi.dto.Product;

public interface ProductRepoistry {

	List<Product> getAllProduct() throws SQLException, ClassNotFoundException;

	int createProduct(Product product) throws SQLException;

	String removeProduct(int id) throws ClassNotFoundException, SQLException;

	String updateProduct(int id, Product prodWithOutIdProp) throws ClassNotFoundException, SQLException;

	Product getParticularProd(int id) throws ClassNotFoundException, SQLException;

}