package org.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.factory.AdminServiceFactory;
import org.factory.CourseServiceFactory;
import org.factory.StudentServiceFactory;
import org.pojo.Admin;
import org.pojo.Course;
import org.pojo.Student;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String sid;
	private String password;
	private String sname;
	private String gender;
	private Date birthday;
	private String address;
	private String telephone;
	
	private String cid;
	private String cname;
	private String cteacher;
	private String ctime;
	private Integer ccredits;
	private String caddress;
	
	private int pageNo=1;
	private int pageSize=2;
	private String keyword="";
	private String column="cid";
	
	private int count;
	
	private Course course;
	
	private List<Course> allCourse;
	private List<Course> allSelectionList;
	
	private int type;
	private Student student;
	private Admin admin;

	public String login() throws Exception{
		type=(Integer) ServletActionContext.getRequest().getAttribute("type");
		if(type==1){
			//判断为学生
			student=new Student();
			student.setSid(sid);
			student.setPassword(password);
			if(StudentServiceFactory.getIStudentServiceInstance().isLogin(student)){
				setStudentAttribute("student");
				return "welcome";
			}
		} else {
			//判断为管理员
			admin=new Admin();
			admin.setAid(sid);
			admin.setApassword(password);
			if(AdminServiceFactory.getIAdminServiceInstance().idLogin(admin)){
				ServletActionContext.getRequest().getSession().setAttribute("admin",admin);
				return "welcome";
			}
		}
		return "fail";
	}
	
	public String update() throws Exception {
		updateStudent();
		StudentServiceFactory.getIStudentServiceInstance().upDate(student);
		student=StudentServiceFactory.getIStudentServiceInstance().findById(student.getSid());
		setStudentAttribute("student");
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
		allCourse=new ArrayList<Course>();
		Map<String, Object> map=new HashMap<String, Object>();
		map= CourseServiceFactory.getICourseServiceInstance().findAll(pageNo, pageSize, keyword, column);
		for(Course cl:(List<Course>)map.get("findAll")){
			allCourse.add(cl);
		}
		count=(Integer) map.get("allCount");
		return "courseList";
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
	
	public String getACourse() throws Exception{
		Course acourse=CourseServiceFactory.getICourseServiceInstance().findById(course.getCid());
		
		course.setCid(acourse.getCid());
		course.setCname(acourse.getCname());
		course.setCteacher(acourse.getCteacher());
		course.setCtime(acourse.getCtime());
		course.setCaddress(acourse.getCaddress());
		course.setCcredits(acourse.getCcredits());
		Set<Course> allSelectionSet=new HashSet<Course>();
		
		student=(Student) ServletActionContext.getRequest().getSession().getAttribute("student");
		
		allSelectionSet=student.getCourses();
		
		allSelectionSet.add(acourse);
		student.setCourses(allSelectionSet);
		
		StudentServiceFactory.getIStudentServiceInstance().upDate(student);
		setStudentAttribute("student");
		
		
		
//		for(Course as:allSelection){
//			allCourse.add(as);
//		}
//		allCourse.add(acourse);
//		以上是将已有选课和刚选课程加入到列表allCourse中
		
		
		
		return "getACourseSeccess";
	}
	
	public void setStudentAttribute(String name) throws Exception{
		ServletActionContext.getRequest().getSession().setAttribute(name,student);
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Course> getAllCourse() {
		return allCourse;
	}

	public void setAllCourse(List<Course> allCourse) {
		this.allCourse = allCourse;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
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