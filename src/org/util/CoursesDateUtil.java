package org.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.factory.CourseServiceFactory;
import org.factory.StudentServiceFactory;
import org.pojo.Course;
import org.pojo.Student;

public class CoursesDateUtil {
	
	public static void main(String[] args) throws Exception{
		insertCourses();
	}
	
	public static void insertCourses() throws Exception{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		java.util.Date date=new java.util.Date();  
		
		Course course=new Course();
		for(int i=1;i<100;i++){
			course=new Course();
			course.setCid(""+i);
			course.setCname(name1()+name2());
			course.setCteacher(cteacher());
			course.setCtime(sdf.format(ctime())+" 至 "+sdf.format(ctime()));
			course.setCaddress(caddress());
			course.setCcredits(ccredits());
			CourseServiceFactory.getICourseServiceInstance().add(course);
		}
	}
	
	public static String name1(){
		String[] all={"Java","C语言","Python","C#","PHP",".Net"};
		Random random=new Random();
		return all[Math.abs(random.nextInt()%all.length)];
	}
	
	public static String name2(){
		String[] all={"基础","进阶","应用","概论","设计","编程"};
		Random random=new Random();
		return all[Math.abs(random.nextInt()%all.length)];
	}
	
	public static String cteacher(){
		String[] all={"王老师","张老师","徐老师","江老师","刘老师","陈老师"};
		Random random=new Random();
		return all[Math.abs(random.nextInt()%all.length)];
	}
	
	public static Date ctime(){
		return randomDate("2017-03-01","2017-07-01"); 
	}
	
	public static String caddress(){
		String[] all={"逸夫楼101","逸夫楼601","逸夫楼504","逸夫楼502","逸夫楼419","逸夫楼401","博学楼119","博学楼802","博学楼402","博学楼709"};
		Random random=new Random();
		return all[Math.abs(random.nextInt()%all.length)];
	}
	
	public static int ccredits(){
		Random random=new Random();
		int a=3;
		int b=Math.abs(random.nextInt()%5);
		return b==0?a:b;
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

