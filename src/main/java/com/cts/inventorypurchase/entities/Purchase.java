package com.cts.inventorypurchase.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table
public class Purchase {
	@Id
	@ApiModelProperty(notes="Purchase id")
	private int id;
	@ApiModelProperty(notes="Purchase name")
	private String name;
	@ApiModelProperty(notes="Purchase description")
	private String description;
	@ApiModelProperty(notes="Purchase cost")
	private double price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
