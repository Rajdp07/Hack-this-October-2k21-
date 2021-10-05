package com.shopping.appllication;

import java.util.ArrayList;
import java.util.List;

import com.shopping.cart.Cart;
import com.shopping.product.Product;

public class Main {
public static void main(String arg[]) {
	Product p1=new Product("Shirt","Dress",790.88f);
	Product p2=new Product("Shirt","Dress",790.88f);
	Product p3=new Product("Shirt","Dress",790.88f);
	Product p4=new Product("Shirt","Dress",790.88f);
	Product p5=new Product("Shirt","Dress",790.88f);
	List<Product> p=new ArrayList<>();
	p.add(p1);
	p.add(p2);
	p.add(p3);
	p.add(p4);
	p.add(p5);
//	p.add(p1);
	
	
	Cart c=new Cart();
//	c.add(p1);
//	c.add(p2);
//	c.add(p3);
//	c.add(p4);
//	c.add(p5);
	
  c.setBookingId(1);
  c.setQuantity(2);
  c.setProduct(p);
  System.out.println(c);
}
}
