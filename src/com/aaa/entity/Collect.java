package com.aaa.entity;

public class Collect {
	private int id;
	private int pid;
	private String uid;
	public Collect() {}
	public Collect(int id, int pid, String uid) {
		this.id = id;
		this.pid = pid;
		this.uid = uid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "Collect [id=" + id + ", pid=" + pid + ", uid=" + uid + "]";
	}
	
	
}
