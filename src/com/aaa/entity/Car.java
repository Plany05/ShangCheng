package com.aaa.entity;

public class Car{

 private int oid;

 private String uid;

 private String pid;

 private String pname;

 private String pimage;

 private String price;

 private String num;

 public Car() {

}
 
 public Car (int oid, String uid, String pid, String pname, String pimage, String price, String num) {
this.oid = oid;
this.uid = uid;
this.pid = pid;
this.pname = pname;
this.pimage = pimage;
this.price = price;
this.num = num;
}
 public void setOid(int oid) {
	    this.oid = oid;
 }

 public int getOid() {
		return oid;
}

 public void setUid(String uid) {
	    this.uid = uid;
 }

 public String getUid() {
		return uid;
}

 public void setPid(String pid) {
	    this.pid = pid;
 }

 public String getPid() {
		return pid;
}

 public void setPname(String pname) {
	    this.pname = pname;
 }

 public String getPname() {
		return pname;
}

 public void setPimage(String pimage) {
	    this.pimage = pimage;
 }

 public String getPimage() {
		return pimage;
}

 public void setPrice(String price) {
	    this.price = price;
 }

 public String getPrice() {
		return price;
}

 public void setNum(String num) {
	    this.num = num;
 }

 public String getNum() {
		return num;
}

 public String toString() {
 return "Car [oid=" + oid + ", uid=" + uid + ", pid=" + pid + 
", pname=" + pname + ", pimage=" + pimage + ", price=" + price + 
", num=" + num + "]";
}
}
