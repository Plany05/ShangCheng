package com.aaa.entity;
import java.util.Date;

public class Orders{

 private String oid;

 private Date ordertime;

 private double total;

 private int state;

 private String address;

 private String name;

 private String telephone;

 private String uid;

 public Orders() {

}
 
 public Orders (String oid, Date ordertime, double total, int state, String address, String name, String telephone, String uid) {
this.oid = oid;
this.ordertime = ordertime;
this.total = total;
this.state = state;
this.address = address;
this.name = name;
this.telephone = telephone;
this.uid = uid;
}
 public void setOid(String oid) {
	    this.oid = oid;
 }

 public String getOid() {
		return oid;
}

 public void setOrdertime(Date ordertime) {
	    this.ordertime = ordertime;
 }

 public Date getOrdertime() {
		return ordertime;
}

 public void setTotal(double total) {
	    this.total = total;
 }

 public double getTotal() {
		return total;
}

 public void setState(int state) {
	    this.state = state;
 }

 public int getState() {
		return state;
}

 public void setAddress(String address) {
	    this.address = address;
 }

 public String getAddress() {
		return address;
}

 public void setName(String name) {
	    this.name = name;
 }

 public String getName() {
		return name;
}

 public void setTelephone(String telephone) {
	    this.telephone = telephone;
 }

 public String getTelephone() {
		return telephone;
}

 public void setUid(String uid) {
	    this.uid = uid;
 }

 public String getUid() {
		return uid;
}

 public String toString() {
 return "Orders [oid=" + oid + ", ordertime=" + ordertime + ", total=" + total + 
", state=" + state + ", address=" + address + ", name=" + name + 
", telephone=" + telephone + ", uid=" + uid + "]";
}
}
