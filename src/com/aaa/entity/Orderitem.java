package com.aaa.entity;

public class Orderitem{

 private String itemid;

 private int count;

 private double subtotal;

 private String pid;

 private String oid;

 public Orderitem() {

}
 
 public Orderitem (String itemid, int count, double subtotal, String pid, String oid) {
this.itemid = itemid;
this.count = count;
this.subtotal = subtotal;
this.pid = pid;
this.oid = oid;
}
 public void setItemid(String itemid) {
	    this.itemid = itemid;
 }

 public String getItemid() {
		return itemid;
}

 public void setCount(int count) {
	    this.count = count;
 }

 public int getCount() {
		return count;
}

 public void setSubtotal(double subtotal) {
	    this.subtotal = subtotal;
 }

 public double getSubtotal() {
		return subtotal;
}

 public void setPid(String pid) {
	    this.pid = pid;
 }

 public String getPid() {
		return pid;
}

 public void setOid(String oid) {
	    this.oid = oid;
 }

 public String getOid() {
		return oid;
}

 public String toString() {
 return "Orderitem [itemid=" + itemid + ", count=" + count + ", subtotal=" + subtotal + 
", pid=" + pid + ", oid=" + oid + "]";
}
}
