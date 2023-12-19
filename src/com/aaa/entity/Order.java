package com.aaa.entity;

public class Order {
	private int id;
	private String uid;
	private String pid;
	private String tradeNum;
	private String province;
	private String city;
	private String county;
	private String site;
	private String phone;
	private String consigneeName;
	public Order() {}
	public Order(int id, String uid, String pid, String tradeNum, String province, String city, String county,
			String site, String phone, String consigneeName) {
		super();
		this.id = id;
		this.uid = uid;
		this.pid = pid;
		this.tradeNum = tradeNum;
		this.province = province;
		this.city = city;
		this.county = county;
		this.site = site;
		this.phone = phone;
		this.consigneeName = consigneeName;
	}
	public Order(int id, String uid, String tradeNum, String province, String city, String county,
			String site, String phone, String consigneeName) {
		super();
		this.id = id;
		this.uid = uid;
		this.tradeNum = tradeNum;
		this.province = province;
		this.city = city;
		this.county = county;
		this.site = site;
		this.phone = phone;
		this.consigneeName = consigneeName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getTradeNum() {
		return tradeNum;
	}
	public void setTradeNum(String tradeNum) {
		this.tradeNum = tradeNum;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getConsigneeName() {
		return consigneeName;
	}
	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", uid=" + uid + ", pid=" + pid + ", tradeNum=" + tradeNum + ", province=" + province
				+ ", city=" + city + ", county=" + county + ", site=" + site + ", phone=" + phone + ", consigneeName="
				+ consigneeName + "]";
	}
	
}
