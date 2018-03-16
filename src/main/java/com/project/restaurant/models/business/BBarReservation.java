package com.project.restaurant.models.business;

import java.util.List;

import com.project.restaurant.models.Items;

public class BBarReservation {
	private Long table_id;
	private Integer capacity;
	private String status;
	private Integer user_id;
	private List<Items> items;
	
	public BBarReservation() {
		// TODO Auto-generated constructor stub
	}

	public BBarReservation(Long table_id, Integer capacity, List<Items> items) {
		super();
		this.table_id = table_id;
		this.capacity = capacity;
		this.items = items;
	}

	public Long getTable_id() {
		return table_id;
	}

	public void setTable_id(Long table_id) {
		this.table_id = table_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "BBarReservation [table_id=" + table_id + ", capacity=" + capacity + ", items=" + items + "]";
	}
	
	
}
