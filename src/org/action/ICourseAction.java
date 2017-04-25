package org.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import org.pojo.Course;
import org.pojo.Student;
import org.factory.CourseServiceFactory;

import com.opensymphony.xwork2.ActionSupport;

public class ICourseAction extends ActionSupport{

	//传值
	private String url;
	
	private String message;
	
    private String[] courseId;
    private Course cous;
    
	//分页属性
	private int pageNo = 1 ;
	private int pageSize = 5;
	private String keyword = "";
	private String column = "cid";
	private int allCount;
	
	
	private List<Course> allCourses ;
	private List<Course> allCourse ;
	
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

	public String[] getCourseId() {
		return courseId;
	}

	public void setCourseId(String[] courseId) {
		this.courseId = courseId;
	}



	public Course getCous() {
		return cous;
	}




	public void setCous(Course cous) {
		this.cous = cous;
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



	public List<Course> getAllCourses() {
		return allCourses;
	}


	public void setAllCourses(List<Course> allCourses) {
		this.allCourses = allCourses;
	}



	public List<Course> getAllCourse() {
		return allCourse;
	}


	public void setAllCourse(List<Course> allCourse) {
		this.allCourse = allCourse;
	}








	public String list()throws Exception{
		Map<String, Object> map =CourseServiceFactory.getICourseServiceInstance().list(pageNo, pageSize, keyword, column);
		allCourses = (List<Course>) map.get("allCourses");
		allCount=(Integer) map.get("count");
		System.out.println(allCount);
	 
	
		// 取得当前已经选择的课程信息
		Student loginUser = (Student) ServletActionContext.getRequest().getSession().getAttribute("student");
		Set<Course> allSelectedCourse = loginUser.getCourses();
		if (allSelectedCourse != null) {
			Iterator<Course> iter = allSelectedCourse.iterator();
			courseId = new String[allSelectedCourse.size()];
			int index = 0;
			while (iter.hasNext()) {
				Course c = iter.next();
				courseId[index++] = c.getCid();
			}
		}
		return "clist";
	}
}
