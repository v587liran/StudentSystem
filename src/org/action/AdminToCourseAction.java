package org.action;

import java.util.List;
import java.util.Map;

import org.factory.CourseServiceFactory;
import org.pojo.Course;

import com.opensymphony.xwork2.ActionSupport;

public class AdminToCourseAction extends ActionSupport {
	private int pageNo = 1;
	private int pageSize = 5;
	private String keyword = "";
	private String column = "cid";
	private int allCount;
	private List<Course> courseList;
	private Course course;
	private String url;
	

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	
	public String getCourses()  throws Exception{
		Map<String, Object> map=CourseServiceFactory.getICourseServiceInstance().findAll(pageNo, pageSize, keyword, column);
		courseList=(List<Course>) map.get("findAll");
		allCount=(Integer)map.get("allCount");
		return "Admin_CourseList";
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	public String insert() throws Exception{
		CourseServiceFactory.getICourseServiceInstance().add(course);
		return getCourses();
		
	}
	
   //删除课程
	public String delete() throws Exception{
		CourseServiceFactory.getICourseServiceInstance().delete(course.getCid());
		return getCourses();
	}
	public String getCourseById() throws Exception{
		course = CourseServiceFactory.getICourseServiceInstance().findById(course.getCid());
		url = "adminToCourse!update.action";
		return "Course_Insert";
	}
	public String update() throws Exception{
		CourseServiceFactory.getICourseServiceInstance().update(course);
		return getCourses();
	}
	public String proadd() throws Exception{
		url = "adminToCourse!insert.action";
		return "Course_Insert";
	}
	public String findCourse() throws Exception {
		course = CourseServiceFactory.getICourseServiceInstance().findById(course.getCid());
		return "course_info";
	}
}
