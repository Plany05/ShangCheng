package com.aaa.entity;

public class Category{

 private String cid;

 private String cname;

 public Category() {

}
 
 public Category (String cid, String cname) {
this.cid = cid;
this.cname = cname;
}
 public void setCid(String cid) {
	    this.cid = cid;
 }

 public String getCid() {
		return cid;
}

 public void setCname(String cname) {
	    this.cname = cname;
 }

 public String getCname() {
		return cname;
}

 public String toString() {
 return "Category [cid=" + cid + ", cname=" + cname + "]";
}
}
