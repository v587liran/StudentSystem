package org.action;

import java.util.List;

import org.factory.CourseServiceFactory;
import org.pojo.Course;

import com.opensymphony.xwork2.ActionSupport;

public class CourseAction extends ActionSupport {
	private String cid;
	private String cname;
	private String cteacher;
	private String ctime;
	private Integer ccredits;
	private String caddress;
	
	private List<Course> allCourses;
	
	private Course course;
	
	public String upDate() throws Exception{
		
		
		return "upDate";
	}
	
	public String aCourseInfo() throws Exception{
		Course acourse=CourseServiceFactory.getICourseServiceInstance().findById(course.getCid());
		course.setCid(acourse.getCid());
		course.setCname(acourse.getCname());
		course.setCteacher(acourse.getCteacher());
		course.setCtime(acourse.getCtime());
		course.setCaddress(acourse.getCaddress());
		course.setCcredits(acourse.getCcredits());
		return "course_info";
	}
	
	public List<Course> getAllCourses() {
		return allCourses;
	}
	public void setAllCourses(List<Course> allCourses) {
		this.allCourses = allCourses;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCteacher() {
		return cteacher;
	}
	public void setCteacher(String cteacher) {
		this.cteacher = cteacher;
	}
	public String getCtime() {
		return ctime;
	}
	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	public Integer getCcredits() {
		return ccredits;
	}
	public void setCcredits(Integer ccredits) {
		this.ccredits = ccredits;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
}
