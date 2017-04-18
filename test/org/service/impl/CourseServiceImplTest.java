package org.service.impl;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.factory.CourseServiceFactory;
import org.factory.StudentServiceFactory;
import org.junit.Test;
import org.pojo.Course;
import org.pojo.Student;

public class CourseServiceImplTest {

	@Test
	public void testAdd() throws Exception {
		Course course=new Course();
		course.setCid("01");
		course.setCname("Java");
		CourseServiceFactory.getICourseServiceInstance().add(course);
	}

	@Test
	public void testDelete() throws Exception {
		CourseServiceFactory.getICourseServiceInstance().delete("01");
	}

	@Test
	public void testUpdate() throws Exception {
		Course course=new Course();
		course.setCid("110");
		course.setCname("Java");
		CourseServiceFactory.getICourseServiceInstance().update(course);
	}

	@Test
	public void testFindById() throws Exception {
		System.out.println(CourseServiceFactory.getICourseServiceInstance().findById("110").getCname());
	}

	@Test
	public void testFindAll() throws Exception {
		Map<String,Object> map=new HashMap<String ,Object>();
		map=CourseServiceFactory.getICourseServiceInstance().findAll(2, 2, "1", "cid");
		List<Course> list=(List<Course>)map.get("findAll");
		
		System.out.println(map.get("allCount")+"-----");
		
		for(Course l:list){
			System.out.println(l.getCname());
		}
	}

}
