package org.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private String sid;
	private String password;
	private String sname;
	private String gender;
	private Date birthday;
	private String address;
	private String telephone;
	private Set courses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(String sid) {
		this.sid = sid;
	}

	/** full constructor */
	public Student(String sid, String password, String sname, String gender,
			Date birthday, String address, String telephone, Set courses) {
		this.sid = sid;
		this.password = password;
		this.sname = sname;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.telephone = telephone;
		this.courses = courses;
	}

	// Property accessors

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Set getCourses() {
		return this.courses;
	}

	public void setCourses(Set courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", password=" + password + ", sname="
				+ sname + ", gender=" + gender + ", birthday=" + birthday
				+ ", address=" + address + ", telephone=" + telephone
				+ ", courses=" + courses + "]";
	}

	
}