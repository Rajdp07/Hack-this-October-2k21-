package com.shopping.cart;

import java.util.List;

import com.shopping.product.Product;

public class Cart {
private int quantity;
private int bookingId;
private List<Product> product;
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getBookingId() {
	return bookingId;
}
public void setBookingId(int bookingId) {
	this.bookingId = bookingId;
}
public List<Product> getProduct() {
	return product;
}
public void setProduct(List<Product> product) {
	this.product = product;
}

public void add(Product p) {
	product.add(p);
}
@Override
public String toString() {
	return "Cart [quantity=" + quantity + ", bookingId=" + bookingId + ", product=" + product + "]";
}
}
