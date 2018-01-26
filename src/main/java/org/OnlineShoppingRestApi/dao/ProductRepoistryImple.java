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

	@Override
	public int createProduct(Product product) throws SQLException {
		System.out.println("createProduct is invoked in repositry");
		Connection con = db.Connect();
		String sql = "insert into onlineshopping_table value (?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, product.getProductId());
		ps.setString(2, product.getProductName());
		ps.setString(3, product.getProductCode());
		
		ps.setString(4, product.getProductAvaliableDate());
		ps.setInt(5, product.getPrice());
		ps.setInt(6, product.getProductRating());
		ps.setString(7, product.getProductImage());
		
		int i = ps.executeUpdate();
		System.out.println(i +" inserted sucessfully....");
		return i;
		
	}
	
	@Override
	public String removeProduct(int id) throws ClassNotFoundException, SQLException {
		Connection con = db.Connect();
		String sql = "delete from onlineshopping_table where productId=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		int i = ps.executeUpdate();
		con.close();
		return i  + " product deleted sucessfully..";

	}
	
	@Override
	public String updateProduct(int id, Product prodWithOutIdProp) throws ClassNotFoundException, SQLException {
		Connection con = db.Connect();
		System.out.println("id value at service class is :"+ id);
		String sql = "update onlineshopping_table set productName=?,productCode=?,productAvaliableDate=?,price=?,productRating=?,productImage=? where productId=?";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, prodWithOutIdProp.getProductName());
		ps.setString(2, prodWithOutIdProp.getProductCode());
		ps.setString(3,prodWithOutIdProp.getProductAvaliableDate() );
		ps.setInt(4,prodWithOutIdProp.getPrice());
		ps.setInt(5,prodWithOutIdProp.getProductRating());
		ps.setString(6, prodWithOutIdProp.getProductImage());
		ps.setInt(7, id);
		
		System.out.println(prodWithOutIdProp);
		int i = ps.executeUpdate();
		con.close();
		return i + " product update sucessfully..";
	}
	
	@Override
	public Product getParticularProd(int id) throws ClassNotFoundException, SQLException {
		Connection con = db.Connect();
		String sql = "select * from onlineshopping_table where productId=?";

		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		Product prod = new Product();
		prod.setProductId(rs.getInt("productId"));
		prod.setProductName(rs.getString("productName"));
		prod.setProductCode(rs.getString("productCode"));
		prod.setProductAvaliableDate(rs.getString("productAvaliableDate"));
		prod.setPrice(rs.getInt("price"));
		prod.setProductRating(rs.getInt("productRating"));
		prod.setProductImage(rs.getString("productImage"));
		System.out.println(prod);
		return prod;
		
		
		
	}
}