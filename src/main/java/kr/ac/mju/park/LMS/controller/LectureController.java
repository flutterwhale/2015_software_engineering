package kr.ac.mju.park.LMS.controller;

import java.util.ArrayList;

import kr.ac.mju.park.LMS.model.Course;
import kr.ac.mju.park.LMS.model.Lecture;
import kr.ac.mju.park.LMS.service.LectureService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller 
public class LectureController {
	@Autowired  
	private LectureService lectureService;
	private static final Logger logger = LoggerFactory
			.getLogger(LectureController.class);

	
	@RequestMapping(value = "/LectureController/AllLecturePage", method = RequestMethod.GET)
	public ModelAndView showAllLecturePage() {
		logger.info("강좌 목록:개설된 강좌 전체 목록 조회/삭제");
		ModelAndView model = new ModelAndView();
		ArrayList<Lecture> myLecutures = lectureService.getAllLecture();
		model.addObject("MyLectures", myLecutures);
		model.setViewName("showAllLecture");
		return model;
	} 
	
	


	@RequestMapping(value = "/LectureController/showStudentPage", method = RequestMethod.GET)
	public ModelAndView showStudentPage(@RequestParam("lecture_id") String lecture_id,String user_id,String insertHJ) {
		logger.info("강좌 목록:개설한 강좌 목록 조회/삭제");
		ModelAndView model = new ModelAndView();
		ArrayList<Course> myStudents = lectureService.StudentList( lecture_id, user_id,insertHJ);
		model.addObject("MyStudents", myStudents);
		model.setViewName("ShowMyStudent"); //jsp ShowMyStudent.jsp
		return model;
	} 
	
	
	@RequestMapping(value = "/LectureController/myLecturePage", method = RequestMethod.GET)
	public ModelAndView showRequestcheckForLecturePage(@RequestParam("user_id")  String user_id) {
		logger.info("강좌 목록:개설한 강좌 목록 조회/삭제");
		ModelAndView model = new ModelAndView();
		ArrayList<Lecture> myLecutures = lectureService.getMyLecture(user_id);
		model.addObject("MyLectures", myLecutures);
		model.setViewName("showMyLecture");
		return model;
	} 
	
	@RequestMapping(value = "/LectureController/deleteLecture", method = RequestMethod.POST)
	public String deleteForLecture(@RequestParam("lecture_id") String lectureID, String user_id) {
		logger.info("강좌 삭제:강좌 삭제"+user_id+ " " + lectureID );
		lectureService.deleteLecture(lectureID,user_id);
		return "redirect:myLecturePage?user_id="+user_id+"";
	}
	
	@RequestMapping(value = "/LectureController/insertLecturePage", method = RequestMethod.POST)
	public ModelAndView showRequestForlecturePage(@RequestParam("user_id")  String user_id) {
		logger.info("강좌 등록 페이지 호출"+user_id);
		ModelAndView model = new ModelAndView();
		model.addObject("MyLectures", user_id);
		model.setViewName("insertLecture");
		return model;
	}
	
	@RequestMapping(value = "/LectureController/insertLecture", method = RequestMethod.POST)
	public String requestForLecture(@RequestParam("user_id") String user_id,String lecture_name,int Hackjeom,int limitN, String lecture_semester) {
		logger.info("강좌 등록:등록 강좌 번호->    ID " + user_id + " " +lecture_name + " " +limitN);
		System.out.println("TEST");
		
		lectureService.insertLecture( user_id, lecture_name, Hackjeom, limitN, lecture_semester);
		return "redirect:myLecturePage?user_id="+user_id+"";
	}
}  
