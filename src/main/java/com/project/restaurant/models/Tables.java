/**
 * 
 */
package com.project.restaurant.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Nguyen Chung Duc
 *
 */
@Entity
public class Tables {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    
    private String name;
    
    private String code;
    
    private Integer capacity;

	public Tables() {
		// TODO Auto-generated constructor stub
	}
    
    public Tables(String name, String code, Integer capacity) {
    	this.name = name;
    	this.code = code;
    	this.capacity = capacity;
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

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
}
