package com.marolix.set7.springbootdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
public class MenuDTO {

	private Long prodId;
	private String prodName;
	private Float price;

	public MenuDTO(Long prodId, String prodName, Float price) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.price = price;
	}

	public MenuDTO() {
		super();
	}

	@Override
	public String toString() {
		return "MenuDTO [prodId=" + prodId + ", prodName=" + prodName + ", price=" + price + "]";
	}

	public void setPrice(Float price2) {
		this.price=price2;
		
	}

	public Long getProdId() {
		return prodId;
	}

	public void setProdId(Long prodId) {
		this.prodId = prodId;
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

}
