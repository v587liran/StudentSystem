package org.action;

import org.apache.struts2.ServletActionContext;
import org.factory.AdminServiceFactory;
import org.factory.StudentServiceFactory;
import org.pojo.Admin;
import org.pojo.Student;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String userid;
	private String userpassword;
	private int type;
	
	private Student student;
	private Admin admin;

	public String login() throws Exception{
		type=(Integer) ServletActionContext.getRequest().getAttribute("type");
		if(type==1){
			//判断为学生
			student=new Student();
			student.setSid(userid);
			student.setPassword(userpassword);
			if(StudentServiceFactory.getIStudentServiceInstance().isLogin(student)){
				ServletActionContext.getRequest().getSession().setAttribute("student",student);
				return "studentwelcome";
			}else{
				this.addFieldError("login", "帐号或者密码输入有误，请重新输入");
				return "fail";
			}
		} else if(type==0) {
			//判断为管理员
			admin=new Admin();
			admin.setAid(userid);
			admin.setApassword(userpassword);
			if(AdminServiceFactory.getIAdminServiceInstance().idLogin(admin)){
				ServletActionContext.getRequest().getSession().setAttribute("admin",admin);
				return "adminwelcome";
			}else{
				this.addFieldError("login", "帐号或者密码输入有误，请重新输入");
				return "fail";
			}
		}
		return "fail";
	}
	
	public String Admin_logout() throws Exception{
		ServletActionContext.getRequest().getSession().removeAttribute("admin");
		return "logout";
	}
	
	public String Student_logout() throws Exception{
		ServletActionContext.getRequest().getSession().removeAttribute("student");
		return "logout";
	}
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
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

	
}