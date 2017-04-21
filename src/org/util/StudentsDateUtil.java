package org.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.factory.StudentServiceFactory;
import org.pojo.Student;

public class StudentsDateUtil {
	
	public static void main(String[] args) throws Exception{
		insertStudents();
	}
	
	public static void insertStudents() throws Exception{
		Student student=new Student();
		for(int i=0;i<1000;i++){
			student=new Student();
			student.setSid(""+i);
			student.setSname(name1()+name2());
			student.setPassword("123456");
			student.setGender(gender());
			student.setBirthday(birthday());
			student.setAddress(address());
			student.setTelephone(telephone());
			StudentServiceFactory.getIStudentServiceInstance().addStudent(student);
		}
	}
	
	public static String name1(){
		String[] all={"李","刘","江","黄","陈","祁"};
		Random random=new Random();
		return all[Math.abs(random.nextInt()%all.length)];
	}
	
	public static String name2(){
		String[] all={"数据","结构","系统","算法","设计","概论","编程"};
		Random random=new Random();
		return all[Math.abs(random.nextInt()%all.length)];
	}
	
	public static String gender(){
		String[] all={"男","女"};
		Random random=new Random();
		return all[Math.abs(random.nextInt()%all.length)];
	}
	
	public static Date birthday(){
		return randomDate("1990-01-01","1997-01-01"); 
	}
	
	public static String address(){
		String[] all={"贵州省贵阳市","贵州省开阳县","海南省海口市","重庆市","云南省大理市","广州","北京","上海"};
		Random random=new Random();
		return all[Math.abs(random.nextInt()%all.length)];
	}
	
	public static String telephone(){
		Random random=new Random();
		return ""+Math.abs(random.nextInt()%1000000);
	}
	
	private static Date randomDate(String beginDate,String  endDate ){  
		try {  
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
			Date start = format.parse(beginDate);//构造开始日期  
			Date end = format.parse(endDate);//构造结束日期  
			//getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。  
			if(start.getTime() >= end.getTime()){  
				return null;  
			}  
			long date = random(start.getTime(),end.getTime());  
			return new Date(date);  
		} catch (Exception e) {  
			e.printStackTrace();  
		}  
			return null;  
		 
		}  
		 
	private static long random(long begin,long end){  
		long rtn = begin + (long)(Math.random() * (end - begin));  
		//如果返回的是开始时间和结束时间，则递归调用本函数查找随机值  
		if(rtn == begin || rtn == end){  
			return random(begin,end);  
		}  
		return rtn;  
	}
}

