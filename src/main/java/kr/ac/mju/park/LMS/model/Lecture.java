package kr.ac.mju.park.LMS.model;

public class Lecture {
	private int Hackjeom;
	private String teacherName;
	private String teacherID;
	private int lectureID;
	private String CourseCategory;
	private String LectureName;
	private int curNum;
	private int limitNum;

	private String Semester;
	public String getSemester() {
		return Semester;
	}

	public void setSemester(String semester) {
		Semester = semester;
	}
	public int getHackjeom() {
		return Hackjeom;
	}

	public void setHackjeom(int hackjeom) {
		Hackjeom = hackjeom;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}

	public String getCourseCategory() {
		return CourseCategory;
	}

	public void setCourseCategory(String courseCategory) {
		CourseCategory = courseCategory;
	}

	public String getLectureName() {
		return LectureName;
	}

	public void setLectureName(String lectureName) {
		LectureName = lectureName;
	}

	public int getLectureID() {
		return lectureID;
	}

	public void setLectureID(int lectureID) {
		this.lectureID = lectureID;
	}

	public int getCurNum() {
		return curNum;
	}

	public void setCurNum(int curNum) {
		this.curNum = curNum;
	}

	public int getLimitNum() {
		return limitNum;
	}

	public void setLimitNum(int limitNum) {
		this.limitNum = limitNum;
	}

	public void setID(int int1) {
		// TODO Auto-generated method stub
		
	}

}
