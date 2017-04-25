package org.action;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.hibernate.event.SaveOrUpdateEvent;

import org.pojo.Course;
import org.pojo.Student;
import org.factory.CourseServiceFactory;
import org.factory.StudentServiceFactory;

import com.opensymphony.xwork2.ActionSupport;

public class IStudentAction extends ActionSupport {

	private Student student ;
	private String sid;
	private String password;
	private Course course;
	

	private String[] courseId;
	
	
	
	//跳转页赋值
	private String  url ;
	private String message;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String[] getCourseId() {
		return courseId;
	}

	public void setCourseId(String[] courseId) {
		this.courseId = courseId;
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

	public Student getUser() {
		return student;
	}

	public void setUser(Student student) {
		this.student = student;
	}
	
	
		
		
	
	
	//选课功能
	public String selectCourse() throws Exception {
		Student loginUser = (Student) ServletActionContext.getRequest().
				getSession().getAttribute("student");
		
		
		
		if(courseId == null){
			message = "选课失败，未选择课程";
			url="course!list.action";
			return "forward";
		}else{
		for(int i=0 ;i<courseId.length;i++){
			String cid=courseId[i];
			Course course = CourseServiceFactory.getICourseServiceInstance().courseFindById(cid);
			//直接用id查询出课程各项信息
			//course.setCid(cid);此方法只能得到id值，在网页上需要马上取得其他值就显得麻烦
			loginUser.getCourses().add(course);
		}
		StudentServiceFactory.getIStudentServiceInstance().selectCourse(loginUser);
		
		ServletActionContext.getRequest().getSession().setAttribute("student",loginUser);
		
		message = "选课成功";
		url="course!list.action";
		return "forward";}
	}
	
	
	//退选
	public String deleCourse() throws Exception{
		Student loginUser = (Student) ServletActionContext.getRequest().
				getSession().getAttribute("student");
		
		
		Set<Course> set=loginUser.getCourses();
		if(courseId == null){
			message = "退课失败，未选择课程";
			url="students/Students_delete_selectcourse.jsp";
			return "forward";
		}else{
		for(int i=0 ;i<courseId.length;i++){
			String cid=courseId[i];
		
			Course course = CourseServiceFactory.getICourseServiceInstance().courseFindById(cid);
			
			//course.getStudents().remove(loginUser);//删除表中对角色的引用  
			//ServiceFactory.getIUserServiceInstance().delectCou(loginUser);
			set.remove(course);
//			loginUser.getCourses().clear();
//			loginUser.getCourses().add(course);
			
		}
		loginUser.setCourses(set);
		
		StudentServiceFactory.getIStudentServiceInstance().selectCourse(loginUser);
		
		ServletActionContext.getRequest().getSession().setAttribute("student",loginUser);
		
		message = "退选成功";
		url="students/Students_delete_selectcourse.jsp";
		return "forward";
		}
	}
	
}
