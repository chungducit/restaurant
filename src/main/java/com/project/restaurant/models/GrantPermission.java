package com.project.restaurant.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GrantPermission {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Integer permission_id;
	
	private Integer function_id;
	
	private Boolean is_grant;
	
	public GrantPermission() {
		// TODO Auto-generated constructor stub
	}

	public GrantPermission(Integer id, Integer permission_id, Integer function_id, Boolean is_grant) {
		this.id = id;
		this.permission_id = permission_id;
		this.function_id = function_id;
		this.is_grant = is_grant;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPermission_id() {
		return permission_id;
	}

	public void setPermission_id(Integer permission_id) {
		this.permission_id = permission_id;
	}

	public Integer getFunction_id() {
		return function_id;
	}

	public void setFunction_id(Integer function_id) {
		this.function_id = function_id;
	}

	public Boolean getIs_grant() {
		return is_grant;
	}

	public void setIs_grant(Boolean is_grant) {
		this.is_grant = is_grant;
	}
	
	
	
	
}
