package com.qac.oc.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Catagory {
	@Id
	@NotNull
	@Size(min=3, max=225)
	@Column(name="name", nullable=false, length=225)
	private String catagory;
	@Id
	@NotNull
	@JoinColumn(name="products_productID", nullable=false)
	private Product product;
	
	public Catagory() {}
	
	public Catagory(String catagory, Product product) {
		this.catagory = catagory;
		this.product = product;
	}

	public String getCatagory() { return catagory; }
	public Product getProduct() { return product; }

	public void setCatagory(String catagory) { this.catagory = catagory; }
	public void setProduct(Product product) { this.product = product; }
	
	@Override
	public boolean equals(Object obj) {
		if(obj.getClass().equals(this.getClass())) {
			Catagory catagory = (Catagory) obj;
			if (catagory.catagory.equalsIgnoreCase(this.catagory))
				return true;
		}
		return false;
	}
}