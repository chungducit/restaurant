package com.project.restaurant.models.business;

import java.sql.Timestamp;

public class TableInfo {
	private Long id;
    
    private String name;
    
    private Integer bar_reservation_id;
    
    private String code;
    
    private Integer capacity;
    
    private Timestamp booked_time;
	
	private Integer checkin_time;
	
	private Integer checkout_time;
	
	private Integer cancel_time;
	
	private Integer people_quantity;
	
	private Integer discount;
	
	private String status;
	
	private String guest_name;
	
	private String guest_phone;
	
	private Integer booked_user;
	
	private Integer checkin_user;
	
	private Integer checkout_user;
	
	private Integer cancel_user;
	
	private Boolean is_cancel;
	
	public TableInfo() {
		// TODO Auto-generated constructor stub
	}

	public TableInfo(Long id, String name, String code, Integer capacity, Timestamp booked_time, Integer checkin_time,
			Integer checkout_time, Integer cancel_time, Integer people_quantity, Integer discount, String guest_name,
			String guest_phone, Integer booked_user, Integer checkin_user, Integer checkout_user, Integer cancel_user,
			Boolean is_cancel) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.capacity = capacity;
		this.booked_time = booked_time;
		this.checkin_time = checkin_time;
		this.checkout_time = checkout_time;
		this.cancel_time = cancel_time;
		this.people_quantity = people_quantity;
		this.discount = discount;
		this.guest_name = guest_name;
		this.guest_phone = guest_phone;
		this.booked_user = booked_user;
		this.checkin_user = checkin_user;
		this.checkout_user = checkout_user;
		this.cancel_user = cancel_user;
		this.is_cancel = is_cancel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Integer getBar_reservation_id() {
		return bar_reservation_id;
	}

	public void setBar_reservation_id(Integer bar_reservation_id) {
		this.bar_reservation_id = bar_reservation_id;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Timestamp getBooked_time() {
		return booked_time;
	}

	public void setBooked_time(Timestamp booked_time) {
		this.booked_time = booked_time;
	}

	public Integer getCheckin_time() {
		return checkin_time;
	}

	public void setCheckin_time(Integer checkin_time) {
		this.checkin_time = checkin_time;
	}

	public Integer getCheckout_time() {
		return checkout_time;
	}

	public void setCheckout_time(Integer checkout_time) {
		this.checkout_time = checkout_time;
	}

	public Integer getCancel_time() {
		return cancel_time;
	}

	public void setCancel_time(Integer cancel_time) {
		this.cancel_time = cancel_time;
	}

	public Integer getPeople_quantity() {
		return people_quantity;
	}

	public void setPeople_quantity(Integer people_quantity) {
		this.people_quantity = people_quantity;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public String getGuest_name() {
		return guest_name;
	}

	public void setGuest_name(String guest_name) {
		this.guest_name = guest_name;
	}

	public String getGuest_phone() {
		return guest_phone;
	}

	public void setGuest_phone(String guest_phone) {
		this.guest_phone = guest_phone;
	}

	public Integer getBooked_user() {
		return booked_user;
	}

	public void setBooked_user(Integer booked_user) {
		this.booked_user = booked_user;
	}

	public Integer getCheckin_user() {
		return checkin_user;
	}

	public void setCheckin_user(Integer checkin_user) {
		this.checkin_user = checkin_user;
	}

	public Integer getCheckout_user() {
		return checkout_user;
	}

	public void setCheckout_user(Integer checkout_user) {
		this.checkout_user = checkout_user;
	}

	public Integer getCancel_user() {
		return cancel_user;
	}

	public void setCancel_user(Integer cancel_user) {
		this.cancel_user = cancel_user;
	}

	public Boolean getIs_cancel() {
		return is_cancel;
	}

	public void setIs_cancel(Boolean is_cancel) {
		this.is_cancel = is_cancel;
	}
	
}
