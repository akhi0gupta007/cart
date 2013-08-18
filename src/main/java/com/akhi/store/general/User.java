package com.akhi.store.general;

public class User {

	private String userId;
	private String password;
	private String empid;
	private String firstname;
	private String lastName;
	private String addr;
	private String city;

	public User(String userId, String password, String empid, String firstname,
			String lastName, String addr, String city) {
		super();
		this.userId = userId;
		this.password = password;
		this.empid = empid;
		this.firstname = firstname;
		this.lastName = lastName;
		this.addr = addr;
		this.city = city;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", empid="
				+ empid + ", firstname=" + firstname + ", lastName=" + lastName
				+ ", addr=" + addr + ", city=" + city + "]";
	}

	public User() {
		super();
	}

	public User(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public User(String userId, String password, String empid) {
		super();
		this.userId = userId;
		this.password = password;
		this.empid = empid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

}
