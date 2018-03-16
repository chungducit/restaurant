package com.project.restaurant.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    
    private String name;
    
    private String code;
    
    private Long parentId;

	public Category () { 
		// TODO Auto-generated constructor stub
	}
    
    public Category (String name, String code, Long parentId) {
    	this.name = name;
    	this.code = code;
    	this.parentId = parentId;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
    
}
