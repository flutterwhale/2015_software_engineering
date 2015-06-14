package kr.ac.mju.park.LMS.service;

import java.util.ArrayList;

import kr.ac.mju.park.LMS.dao.LectureDAO;
import kr.ac.mju.park.LMS.model.Course;
import kr.ac.mju.park.LMS.model.Lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LectureService{
	@Autowired
	private LectureDAO dao;
	

	
	
	public ArrayList<Lecture> getAllLecture() {
		// TODO Auto-generated method stub
		
		System.out.println("LectureService - getAllLecture()");
		return dao.getAllLectures(); 
	}
	public ArrayList<Lecture> getMyLecture( String userid) {
		// TODO Auto-generated method stub
		return dao.getMyLectures(userid); 
	}
	
	public void insertLecture( String userid,String lecture_name,int Hackjeom,int limitN, String semester) {
		// TODO Auto-generated method stub
		dao.InsertLecture(  userid, lecture_name, Hackjeom, limitN,semester);
	}
	public void deleteLecture(String lectureID, String user_id){
		
		dao.deleteLecture(lectureID, user_id);
	}
	public void updateLecture(String lectureID, String user_id){
		dao.updateLecture(lectureID, user_id);
	}
	

	public ArrayList<Course> StudentList(String lectureID, String user_id, String grade) {
		// TODO Auto-generated method stub
		return dao.MyLectureStudentList(lectureID,user_id,grade);
	}
	
	
}