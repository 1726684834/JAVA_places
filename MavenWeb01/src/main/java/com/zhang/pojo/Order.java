package com.zhang.pojo;

public class Order {
	private Integer id;
	private Integer userId;
	private Integer proId;
	private Integer orNum;
	private Float totalPrice;
	public Order() {
		// TODO Auto-generated constructor stub
	}
	public Order(Integer id, Integer userId, Integer proId, Integer orNum, Float totalPrice) {
		super();
		this.id = id;
		this.userId = userId;
		this.proId = proId;
		this.orNum = orNum;
		this.totalPrice = totalPrice;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getProId() {
		return proId;
	}
	public void setProId(Integer proId) {
		this.proId = proId;
	}
	public Integer getOrNum() {
		return orNum;
	}
	public void setOrNum(Integer orNum) {
		this.orNum = orNum;
	}
	public Float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", proId=" + proId + ", orNum=" + orNum + ", totalPrice="
				+ totalPrice + "]";
	}
}
