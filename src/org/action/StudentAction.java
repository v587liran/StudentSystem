package org.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.factory.CourseServiceFactory;
import org.factory.StudentServiceFactory;
import org.pojo.Course;
import org.pojo.Student;

public class StudentAction {
	private String sid;
	private String password;
	private String sname;
	private String gender;
	private Date birthday;
	private String address;
	private String telephone;
	
	private int pageNo;
	private int pageSize;
	private String keyword;
	private String column;
	private List<Course> courseList;
	
	private String message;
	private String url;
	
	private Student student;

	public String testStudent() throws Exception{
		
		Student student=(Student)ServletActionContext.getRequest().getSession().getAttribute("student");
		
		System.out.println("----------------------------------------------");
		
		System.out.println(student.toString());
		
//		StudentServiceFactory.getIStudentServiceInstance().addStudent(student);
//		message="添加成功";
//		url="pages_seccess.jsp";
		setStudentAttribute("student");
		return "welcome";
	}
	
	public String update() throws Exception{
		updateStudent();
		StudentServiceFactory.getIStudentServiceInstance().upDate(student);
		StudentServiceFactory.getIStudentServiceInstance().findById(student.getSid());
		System.out.println(student.getTelephone());
		return "welcome";
	}
	
	public void updateStudent() throws Exception{
		student=new Student();
		student.setSid(sid);
		student.setPassword(password);
		student.setSname(sname);
		student.setGender(gender);
		student.setBirthday(birthday);
		student.setTelephone(telephone);
		student.setAddress(address);
	}
	
	public String getCourseList() throws Exception{
		courseList=(List<Course>) CourseServiceFactory.getICourseServiceInstance().findAll(pageNo, pageSize, keyword, column);
		return "seleCourse";
	}
	
	
	
	
	public void setStudentAttribute(String name) throws Exception{
		ServletActionContext.getRequest().getSession().setAttribute(name,student);
	}
	
	
	
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
