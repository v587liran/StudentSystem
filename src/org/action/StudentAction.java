package org.action;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	
	private int pageNo=1;
	private int pageSize=5;
	private String keyword="";
	private String column="sid";
	private int allCount;
	
	private List<Student> allStudentsList;
	
	private String message;
	private String url;
	
	private Student students;
	private Student astudent;
	private Student student;
	
	public String update() throws Exception{
		students=new Student();
		students.setSid(sid);
		students.setPassword(password);
		students.setSname(sname);
		students.setGender(gender);
		students.setBirthday(birthday);
		students.setTelephone(telephone);
		students.setAddress(address);
		
		Student student=(Student) ServletActionContext.getRequest().getSession().getAttribute("student");
		students.setCourses(student.getCourses());
		
		StudentServiceFactory.getIStudentServiceInstance().upDate(students);
		Student students=StudentServiceFactory.getIStudentServiceInstance().findById(student.getSid());
		ServletActionContext.getRequest().getSession().setAttribute("student", students);
		
		System.out.println("----------------------------------"+students.getPassword());
		
		return "updateSeccess";
	}

	public String getStudentList() throws Exception{
		Map<String, Object> map=StudentServiceFactory.getIStudentServiceInstance().findAll(pageNo, pageSize, keyword, column);
		allStudentsList=(List<Student>) map.get("findAll");
		allCount=(Integer) map.get("allCount");
		
		System.out.println("---------------"+allCount);
		
		for(Student all:allStudentsList){
			System.out.println(all.getSname()+"--------"+all.getAddress());
		}
		return "allStudentsList";
	}
	
	
	
	public String getAStudentInfo() throws Exception{
		astudent=StudentServiceFactory.getIStudentServiceInstance().findById(student.getSid());
		student=new Student();
		student.setSid(astudent.getSid());
		student.setPassword(astudent.getPassword());
		student.setSname(astudent.getSname());
		student.setGender(astudent.getGender());
		student.setBirthday(astudent.getBirthday());
		student.setTelephone(astudent.getTelephone());
		student.setAddress(astudent.getAddress());
		return "getAStudentInfo";
	}
	
	public String showStudentInfo() throws Exception{
		sid=(String) ServletActionContext.getRequest().getAttribute("sid");
		astudent=StudentServiceFactory.getIStudentServiceInstance().findById(sid);
		Set<Course> seleCourses=astudent.getCourses();
		student=new Student();
		student.setSid(astudent.getSid());
		student.setPassword(astudent.getPassword());
		student.setSname(astudent.getSname());
		student.setGender(astudent.getGender());
		student.setBirthday(astudent.getBirthday());
		student.setTelephone(astudent.getTelephone());
		student.setAddress(astudent.getAddress());
		student.setCourses(seleCourses);
		StudentServiceFactory.getIStudentServiceInstance().upDate(student);
		return "updateStudentInfo";
	}
	
	public String updateStudentInfo() throws Exception{
		sid=(String) ServletActionContext.getRequest().getAttribute("sid");
		astudent=StudentServiceFactory.getIStudentServiceInstance().findById(sid);
		Set<Course> seleCourses=astudent.getCourses();
		student=new Student();
		student.setSid(sid);
		student.setPassword(password);
		student.setSname(sname);
		student.setGender(gender);
		student.setBirthday(birthday);
		student.setTelephone(telephone);
		student.setAddress(address);
		student.setCourses(seleCourses);
		StudentServiceFactory.getIStudentServiceInstance().upDate(student);
		return "updateStudentInfo";
	}
	
	public String delete() throws Exception{
		StudentServiceFactory.getIStudentServiceInstance().delete(student.getSid());
		return "deleteSeccess";
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

	public int getAllCount() {
		return allCount;
	}

	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}

	public List<Student> getAllStudentsList() {
		return allStudentsList;
	}

	public void setAllStudentsList(List<Student> allStudentsList) {
		this.allStudentsList = allStudentsList;
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

	public Student getStudents() {
		return students;
	}

	public void setStudents(Student students) {
		this.students = students;
	}

	public Student getAstudent() {
		return astudent;
	}

	public void setAstudent(Student astudent) {
		this.astudent = astudent;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
