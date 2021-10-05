package com.shopping.product;

public class Product {

private String pName;
private String pType;
private Float pCost;

public Product(String pName, String pType, Float pCost) {
	super();
	this.pName = pName;
	this.pType = pType;
	this.pCost = pCost;
}
@Override
public String toString() {
	return "Product [pName=" + pName + ", pType=" + pType + ", pCost=" + pCost + "]";
}
public String getpName() {
	return pName;
}
public void setpName(String pName) {
	this.pName = pName;
}
public String getpType() {
	return pType;
}
public void setpType(String pType) {
	this.pType = pType;
}
public Float getpCost() {
	return pCost;
}
public void setpCost(Float pCost) {
	this.pCost = pCost;
}

}
