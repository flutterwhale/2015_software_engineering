package kr.ac.mju.park.LMS.model;

public class Course {
	private int ID;
	private String UserID;
	private String name;
	private int Hackjeom;
	private String MyHackjeom;
	private String teacherName;
	private int teacherID;
	private String CourseCategory;
	private String LectureName;
	private String LectureID;
	private String Semester;
	private boolean flag = false;
	
	public int getID() {
		return ID;
	}

	public void setID(int i) {
		ID = i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(int teacherID) {
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

	public void setMyHackjeom(String int1) {
		 MyHackjeom = int1; 
		
	}

	public String getMyHackjeom() {
		return MyHackjeom;
	}

	public String getSemester() {
		return Semester;
	}

	public void setSemester(String semester) {
		Semester = semester;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getLectureID() {
		return LectureID;
	}

	public void setLectureID(String lectureID) {
		LectureID = lectureID;
	}

}
