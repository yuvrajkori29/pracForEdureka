package com.example.util;

import com.example.entity.Product;
import com.example.entity.ProductDAO;
import com.example.entity.Supplier;
import com.example.entity.SupplierDAO;

public class App{
	public static void main(String args[])
	{
		SupplierDAO supplier = new SupplierDAO();
		ProductDAO product = new ProductDAO();
		
		Supplier s1 = new Supplier(1,"Dell","dell@support.com");
		Supplier s2 = new Supplier(2,"HP","dell@support.com");
		
		supplier.addSupplier(s2);
		supplier.addSupplier(s1);
		
		Product p1 = new Product(101,"Dell Aspiron",1,80000);
		Product p2 = new Product(101,"HP probook ",2,80000);
		Product p3 = new Product(101,"HP pavillion",2,80000);
		
		product.addProduct(p3);
		product.addProduct(p2);
		product.addProduct(p1);
		
		
	}
}