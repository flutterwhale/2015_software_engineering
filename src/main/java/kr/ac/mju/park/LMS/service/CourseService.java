package kr.ac.mju.park.LMS.service;

import java.util.ArrayList;

import kr.ac.mju.park.LMS.dao.CourseDAO;
import kr.ac.mju.park.LMS.model.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	@Autowired
	private CourseDAO dao;
	
	public ArrayList<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return dao.getAllCourses(); 
	}
	public ArrayList<Course> getMyCourse(String userID) {
		// TODO Auto-generated method stub
		return dao.getMyCourses(userID); 
		
	}
	
	public ArrayList<Course> getMyHackjeom(String userID) {
		// TODO Auto-generated method stub
		return dao.getMyHackjeom(userID); 
		
	}
	public void checkForCourse(String courseID, String user_id) {
		// TODO Auto-generated method stub
		dao.deleteCourse(courseID, user_id);
	}
	public void registForCourse(String courseID, String user_id, String lecture_name) {
		// TODO Auto-generated method stub
		dao.insertCourse(courseID,user_id,lecture_name);
	}
	
	public void insertHackjeom(String courseID, String user_id, String grade) {
		// TODO Auto-generated method stub
		dao.daoinsertHJ(courseID,user_id,grade);
	}

}