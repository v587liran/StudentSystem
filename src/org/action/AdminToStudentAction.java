package org.action;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.pojo.Student;

import com.opensymphony.xwork2.ActionSupport;

public class AdminToStudentAction extends ActionSupport {
	private String sid;
	private Student student;
	
	
	public String updateAStudentInfo() throws Exception{
		return "updateAStudentInfo_seccess";
	}
}
