package com.example.entity;

public class Product{
	 private int productId;
	 private String productName;
	 private int supplierId;
	 private double price;
	
	
	
	public Product(int productId, String productName, int supplierId, double price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.supplierId = supplierId;
		this.price = price;
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
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	 
	 
}