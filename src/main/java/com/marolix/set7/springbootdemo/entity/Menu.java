package com.marolix.set7.springbootdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "menu_details")
@NamedQuery(name = "Menu.fetchWithNamedQuery", query = "select m from Menu m where m.prodName=?1")
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="prod_id")
	private Long productId;
	@Column(name="prod_name")
	private String prodName;//prod_name
	private Float price;

	
	
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Menu( String prodName) {
		super();
		
		this.prodName = prodName;
		
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Menu [productId=" + productId + ", prodName=" + prodName + ", price=" + price + "]";
	}

}
