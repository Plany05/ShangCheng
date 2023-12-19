package com.aaa.entity;

public class User{

 private int uid;

 private String telephone;

 private String password;

 private String email;

 private String nickname;

 public User() {

}
 
 public User (int uid, String telephone, String password, String email, String nickname) {
this.uid = uid;
this.telephone = telephone;
this.password = password;
this.email = email;
this.nickname = nickname;
}
 public void setUid(int uid) {
	    this.uid = uid;
 }

 public int getUid() {
		return uid;
}

 public void setTelephone(String telephone) {
	    this.telephone = telephone;
 }

 public String getTelephone() {
		return telephone;
}

 public void setPassword(String password) {
	    this.password = password;
 }

 public String getPassword() {
		return password;
}

 public void setEmail(String email) {
	    this.email = email;
 }

 public String getEmail() {
		return email;
}

 public void setNickname(String nickname) {
	    this.nickname = nickname;
 }

 public String getNickname() {
		return nickname;
}

 public String toString() {
 return "User [uid=" + uid + ", telephone=" + telephone + ", password=" + password + 
", email=" + email + ", nickname=" + nickname + "]";
}
}
