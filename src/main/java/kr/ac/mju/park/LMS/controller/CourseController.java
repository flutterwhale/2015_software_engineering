package kr.ac.mju.park.LMS.controller;

import java.util.ArrayList;

import kr.ac.mju.park.LMS.model.Course;
import kr.ac.mju.park.LMS.service.CourseService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller 
public class CourseController {
	@Autowired  
	private CourseService courseService;
	private static final Logger logger = LoggerFactory
			.getLogger(CourseController.class);

	@RequestMapping(value = "/CourseController/insertCoursePage", method = RequestMethod.GET)
	public ModelAndView showRequestForCoursePage() {
		logger.info("수강신청:수강 가능한 과목 나열");
		ModelAndView model = new ModelAndView();
		ArrayList<Course> allCourses = courseService.getAllCourses();
		model.addObject("allCourses", allCourses);
		model.setViewName("insertCourse");
		return model;
	} 

	

	@RequestMapping(value = "/CourseController/showMyHackjeom", method = RequestMethod.GET)
	public ModelAndView showMyHackjeomForCoursePage(@RequestParam("user_id")  String user_id) {
		logger.info("수강신청:수강 신청한 목록 조회/삭제");
		ModelAndView model = new ModelAndView();
		ArrayList<Course> myCourses = courseService.getMyHackjeom(user_id);
		model.addObject("MyCourses", myCourses);
		model.setViewName("showMyHackjeom");
		return model;
	} 
	
	
	
	@RequestMapping(value = "/CourseController/checkCoursePage", method = RequestMethod.GET)
	public ModelAndView showRequestcheckForCoursePage(@RequestParam("user_id")  String user_id) {
		logger.info("수강신청:수강 신청한 목록 조회/삭제");
		ModelAndView model = new ModelAndView();
		ArrayList<Course> myCourses = courseService.getMyCourse(user_id);
		model.addObject("MyCourses", myCourses);
		model.setViewName("checkCourse");
		return model;
	} 
	
	
	 
	
	@RequestMapping(value = "/CourseController/deleteCourse", method = RequestMethod.POST)
	public String checkForCourse(@RequestParam("course_id") String courseID, String user_id) {
		logger.info("수강신청:수강 삭제"+user_id+ " " + courseID );
		courseService.checkForCourse(courseID,user_id);
		return "redirect:checkCoursePage?user_id="+user_id+"";
	}
	
	
	@RequestMapping(value = "/CourseController/insertCourse", method = RequestMethod.POST)
	public String requestForCourse(@RequestParam("course_id") String courseID,String lecture_name, String user_id) {
		logger.info("수강신청:수강 신청한 과목 번호-> " + courseID + "  신청자 ID " + user_id + " " +lecture_name);
		courseService.registForCourse(courseID,user_id,lecture_name);
		return "redirect:insertCoursePage";
	}
	
	@RequestMapping(value = "/CourseController/insertHackjeom", method = RequestMethod.POST)
	public String hackjeom(@RequestParam("courseID") String courseID, String insertHJ, String user_id, String teacher_id) {
		logger.info("수강신청:수강 신청한 과목 번호-> " + courseID + "  신청자 ID " + user_id + " 학점 부여  " +insertHJ + "교수 아이디 "+ teacher_id);
		courseService.insertHackjeom(courseID, user_id, insertHJ);
		return "redirect:/LectureController/showStudentPage?lecture_id="+courseID+"&user_id="+teacher_id+"";
	}
	
	
	
}  
