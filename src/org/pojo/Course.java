package org.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable {

	// Fields

	private String cid;
	private String cname;
	private String cteacher;
	private String ctime;
	private Integer ccredits;
	private String caddress;
	private Set students = new HashSet(0);

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** minimal constructor */
	public Course(String cid) {
		this.cid = cid;
	}

	/** full constructor */
	public Course(String cid, String cname, String cteacher, String ctime,
			Integer ccredits, String caddress, Set students) {
		this.cid = cid;
		this.cname = cname;
		this.cteacher = cteacher;
		this.ctime = ctime;
		this.ccredits = ccredits;
		this.caddress = caddress;
		this.students = students;
	}

	// Property accessors

	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCteacher() {
		return this.cteacher;
	}

	public void setCteacher(String cteacher) {
		this.cteacher = cteacher;
	}

	public String getCtime() {
		return this.ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public Integer getCcredits() {
		return this.ccredits;
	}

	public void setCcredits(Integer ccredits) {
		this.ccredits = ccredits;
	}

	public String getCaddress() {
		return this.caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	public Set getStudents() {
		return this.students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", cteacher="
				+ cteacher + ", ctime=" + ctime + ", ccredits=" + ccredits
				+ ", caddress=" + caddress + ", students=" + students + "]";
	}

}