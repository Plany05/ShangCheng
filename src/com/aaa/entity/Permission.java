package com.aaa.entity;

public class Permission{

 private int id;

 private int parentid;

 private String url;

 private String name;

 private String desc;

 public Permission() {

}
 
 public Permission (int id, int parentid, String url, String name, String desc) {
this.id = id;
this.parentid = parentid;
this.url = url;
this.name = name;
this.desc = desc;
}
 public void setId(int id) {
	    this.id = id;
 }

 public int getId() {
		return id;
}

 public void setParentid(int parentid) {
	    this.parentid = parentid;
 }

 public int getParentid() {
		return parentid;
}

 public void setUrl(String url) {
	    this.url = url;
 }

 public String getUrl() {
		return url;
}

 public void setName(String name) {
	    this.name = name;
 }

 public String getName() {
		return name;
}

 public void setDesc(String desc) {
	    this.desc = desc;
 }

 public String getDesc() {
		return desc;
}

 public String toString() {
 return "Permission [id=" + id + ", parentid=" + parentid + ", url=" + url + 
", name=" + name + ", desc=" + desc + "]";
}
}
