package com.project.restaurant.models.business;

public class ItemInfo {
	private Long id;
	
	private String code;
	
	private String name;
	
	private Double price;
	
	public ItemInfo() {
		// TODO Auto-generated constructor stub
	}
	
	

	public ItemInfo(Long id, String code, String name, Double price) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.price = price;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	
}
