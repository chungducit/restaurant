package com.project.restaurant.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BarReservationDetail {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private Long itemId;
	
	private Integer bar_reservation_id;
	
	private Double price;
	
	private Integer discount;
	
	private Integer quantity;
	
	public BarReservationDetail() {
		// TODO Auto-generated constructor stub
	}

	public BarReservationDetail(Long id, Long itemId, Integer bar_reservation_id, Double price, Integer discount,
			Integer quantity) {
		this.id = id;
		this.itemId = itemId;
		this.bar_reservation_id = bar_reservation_id;
		this.price = price;
		this.discount = discount;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getitemId() {
		return itemId;
	}

	public void setitemId(Long itemId) {
		this.itemId = itemId;
	}

	public Integer getBar_reservation_id() {
		return bar_reservation_id;
	}

	public void setBar_reservation_id(Integer bar_reservation_id) {
		this.bar_reservation_id = bar_reservation_id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	

}
