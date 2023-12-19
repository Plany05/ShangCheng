package com.aaa.entity;

public class Login{

 private int id;

 private String username;

 private String password;

 public Login() {

}
 
 public Login (int id, String username, String password) {
this.id = id;
this.username = username;
this.password = password;
}
 public void setId(int id) {
	    this.id = id;
 }

 public int getId() {
		return id;
}

 public void setUsername(String username) {
	    this.username = username;
 }

 public String getUsername() {
		return username;
}

 public void setPassword(String password) {
	    this.password = password;
 }

 public String getPassword() {
		return password;
}

 public String toString() {
 return "Login [id=" + id + ", username=" + username + ", password=" + password + 
"]";
}
}
