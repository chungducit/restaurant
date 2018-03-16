package com.project.restaurant.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
    
    private String name;
    
    private String username;

	private String password;
    
    private Integer permission_id;
    
    private String phone;
    
    private String access_token;
    
    private Integer expire;

	public User() {
		// TODO Auto-generated constructor stub
	}
    
    public User(String name, String username, String password, Integer permission_id, String phone, String access_token, Integer expire) {
    	this.name = name;
    	this.username = username;
    	this.password = password;
    	this.permission_id = permission_id;
    	this.phone = phone;
    	this.access_token = access_token;
    	this.expire = expire;
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPermission_id() {
		return permission_id;
	}

	public void setPermission_id(Integer permission_id) {
		this.permission_id = permission_id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public Integer getExpire() {
		return expire;
	}

	public void setExpire(Integer expire) {
		this.expire = expire;
	}
    
}
