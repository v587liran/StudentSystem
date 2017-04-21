package org.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.factory.CourseServiceFactory;
import org.pojo.Course;

import com.opensymphony.xwork2.ActionSupport;

public class StudentToCourseAction extends ActionSupport {
	private int pageNo = 1;
	private int pageSize = 5;
	private String keyword ="";
	private String column = "cid";
	private int allCount;
	private List<Course> getASelecourseList;

	public String getASelecourseList() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map=CourseServiceFactory.getICourseServiceInstance().findAll(pageNo, pageSize, keyword, column);
		getASelecourseList =  (List<Course>) map.get("findAll");
		allCount=(Integer) map.get("allCount");
		System.out.println("-------------------"+allCount+"----"+keyword+"----"+column);
		for(Course a:getASelecourseList){
			System.out.println(a.getCname());
		}
		
		return "getASelecourseList";
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

	public List<Course> getGetASelecourseList() {
		return getASelecourseList;
	}

	public void setGetASelecourseList(List<Course> getASelecourseList) {
		this.getASelecourseList = getASelecourseList;
	}

	
}
