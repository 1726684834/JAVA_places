package com.zhang.pojo;

public class Product {
	private Integer id;
	private String proCode;
	private String proName;
	private Integer proNum;
	private Float proPrice;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(Integer id, String proCode, String proName, Integer proNum, Float proPrice) {
		super();
		this.id = id;
		this.proCode = proCode;
		this.proName = proName;
		this.proNum = proNum;
		this.proPrice = proPrice;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProCode() {
		return proCode;
	}

	public void setProCode(String proCode) {
		this.proCode = proCode;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public Integer getProNum() {
		return proNum;
	}

	public void setProNum(Integer proNum) {
		this.proNum = proNum;
	}

	public Float getProPrice() {
		return proPrice;
	}

	public void setProPrice(Float proPrice) {
		this.proPrice = proPrice;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", proCode=" + proCode + ", proName=" + proName + ", proNum=" + proNum
				+ ", proPrice=" + proPrice + "]";
	}
	
	
	
}
