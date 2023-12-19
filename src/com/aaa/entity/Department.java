package com.aaa.entity;

public class Department{

 private int id;

 private String name;

 private String desc;

 private int state;

 public Department() {

}
 
 public Department (int id, String name, String desc, int state) {
this.id = id;
this.name = name;
this.desc = desc;
this.state = state;
}
 public void setId(int id) {
	    this.id = id;
 }

 public int getId() {
		return id;
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

 public void setState(int state) {
	    this.state = state;
 }

 public int getState() {
		return state;
}

 public String toString() {
 return "Department [id=" + id + ", name=" + name + ", desc=" + desc + 
", state=" + state + "]";
}
}
