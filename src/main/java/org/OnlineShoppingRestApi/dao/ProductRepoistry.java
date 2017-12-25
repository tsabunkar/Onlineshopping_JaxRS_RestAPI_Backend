package org.OnlineShoppingRestApi.dao;

import java.sql.SQLException;
import java.util.List;

import org.OnlineShoppingRestApi.dto.Product;

public interface ProductRepoistry {

	List<Product> getAllProduct() throws SQLException, ClassNotFoundException;

}