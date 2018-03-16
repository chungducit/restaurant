package com.project.restaurant.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Integer payment_method_id;
	
	private Double total;
	
	private Integer bar_reservation_id;
	
	private Integer user_paid;
	
	private Integer create_time;
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public Payment(Integer id, Integer payment_method_id, Double total, Integer bar_reservation_id, Integer user_paid,
			Integer create_time) {
		this.id = id;
		this.payment_method_id = payment_method_id;
		this.total = total;
		this.bar_reservation_id = bar_reservation_id;
		this.user_paid = user_paid;
		this.create_time = create_time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPayment_method_id() {
		return payment_method_id;
	}

	public void setPayment_method_id(Integer payment_method_id) {
		this.payment_method_id = payment_method_id;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Integer getBar_reservation_id() {
		return bar_reservation_id;
	}

	public void setBar_reservation_id(Integer bar_reservation_id) {
		this.bar_reservation_id = bar_reservation_id;
	}

	public Integer getUser_paid() {
		return user_paid;
	}

	public void setUser_paid(Integer user_paid) {
		this.user_paid = user_paid;
	}

	public Integer getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Integer create_time) {
		this.create_time = create_time;
	}
	
	
}
