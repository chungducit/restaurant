package com.project.restaurant.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Items {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String code;
	
	private String name;
	
	private Double price;
	
	private Long categoryId;
	
	private Boolean isDelete;
	
	private Integer quantity;
	
	public Items() {
		// TODO Auto-generated constructor stub
	}
	
	public Items (String code, String name, Double price, Long categoryId, Boolean isDelete) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.categoryId = categoryId;
		this.isDelete = isDelete;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}
	
}
