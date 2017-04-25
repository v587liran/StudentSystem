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
	
	private String url;
	
	private Course course;
	
	private int pageNo=1;
	private int pageSize=5;
	private String column="cid";
	private String keyword="";
	private int count;
	
	
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

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

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
	
	//admin
	   //添加课程
		
		
		//修改课程
	
		
		public String List() throws Exception{
			System.out.println("-----------------------------------"+keyword+"____"+column);
			allCourses = (List<Course>) CourseServiceFactory.getICourseServiceInstance().findAll(pageNo, pageSize, keyword, column).get("findAll");
			return "Admin_CourseList";
		}
		
		
		
		
		
		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		private String key;
	
}
