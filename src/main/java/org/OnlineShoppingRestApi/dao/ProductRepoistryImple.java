package org.OnlineShoppingRestApi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.OnlineShoppingRestApi.dto.Product;

public class ProductRepoistryImple implements ProductRepoistry {
	DBConnection db = new DBConnection();

	/* (non-Javadoc)
	 * @see org.OnlineShoppingRestApi.dao.ProductRepoistry#getAllProduct()
	 */
	@Override
	public List<Product> getAllProduct() throws SQLException, ClassNotFoundException {
		Connection con = db.Connect();
		String sql = "select * from onlineshopping_table";
		
		
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<Product> listOfProd = new ArrayList<Product>();
		
		while (rs.next()) {
			Product prod = new Product();
			prod.setProductId(rs.getInt("productId"));
			prod.setProductName(rs.getString("productName"));
			prod.setProductCode(rs.getString("productCode"));
			prod.setProductAvaliableDate(rs.getString("productAvaliableDate"));
			prod.setPrice(rs.getInt("price"));
			prod.setProductRating(rs.getInt("productRating"));
			prod.setProductImage(rs.getString("productImage"));
			System.out.println(prod);
			listOfProd.add(prod);
		}
		con.close();
		return listOfProd;

	}
}
