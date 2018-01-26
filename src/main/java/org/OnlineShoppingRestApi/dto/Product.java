package org.OnlineShoppingRestApi.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {
	private int  productId;
	private String   productName;
	private String    productCode;
	private String  productAvaliableDate;
	private int  price;
	private int  productRating;
	private String   productImage;
	
	public Product() {
		
	}
	
	public Product(int productId, String productName, String productCode, String productAvaliableDate, int price,
			int productRating, String productImage) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCode = productCode;
		this.productAvaliableDate = productAvaliableDate;
		this.price = price;
		this.productRating = productRating;
		this.productImage = productImage;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductAvaliableDate() {
		return productAvaliableDate;
	}
	public void setProductAvaliableDate(String productAvaliableDate) {
		this.productAvaliableDate = productAvaliableDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getProductRating() {
		return productRating;
	}
	public void setProductRating(int productRating) {
		this.productRating = productRating;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCode=" + productCode
				+ ", productAvaliableDate=" + productAvaliableDate + ", price=" + price + ", productRating="
				+ productRating + ", productImage=" + productImage + "]";
	}
	
	
}
