package kr.ac.mju.park.LMS.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kr.ac.mju.park.LMS.model.Course;
import kr.ac.mju.park.LMS.model.Lecture;

import org.springframework.stereotype.Repository;

@Repository
public class LectureDAO  {
	
	
	
	public ArrayList<Lecture> getAllLectures() {
		// TODO Auto-generated method stub
		// 모든 과목 정보 
		
		
		System.out.println("LectureDAO - getAllLectures");
		ArrayList<Lecture> allLectures = new ArrayList<Lecture>();
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		

	
	
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://117.123.66.137:8089/lms", "park",
					"wldnjs7862"); 

			//String query = "select * from " + "lms.tlecture";
			//String query = "SELECT L.LectureID, L.LectureName, L.Hackjeom,U.userName, C.cCategory  FROM (lms.tlecture L join lms.tcourse as C on C.cLectureID = L.LectureID) join lms.tuser as U on L.LteacherID = U.userID;";
			
			String query = "SELECT * FROM lms.tlecture L join lms.tuser as U on L.LteacherID = U.userID;";
			conn = connection;
			pstmt = (PreparedStatement) conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
				System.out.println("전체 과목 나열?");
				allLectures.clear();
				  
				while (rs.next()) {
					 
					
					System.out.println(rs.getString("LectureID") +" " +rs.getString("LectureName"));
					Lecture lecture = new Lecture();
					
					lecture.setLectureID(rs.getInt("LectureID"));
					lecture.setTeacherName(rs.getString("userName"));
					lecture.setLectureName(rs.getString("LectureName"));
					lecture.setHackjeom(rs.getInt("Hackjeom"));
					lecture.setSemester(rs.getString("semester"));
					lecture.setCurNum(rs.getInt("currentNum"));
					lecture.setLimitNum(rs.getInt("LimitNum"));
					
					
					
					allLectures.add(lecture);
				
					
					

					
				}

			
				rs.close();
				pstmt.close();
				conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 
		}

	
		
		
		return allLectures;
		
		
	}

	public ArrayList<Lecture> getMyLectures(String UserID) {
		// TODO Auto-generated method stub
		/* 모든 과목 정보 */
		ArrayList<Lecture> myLectures = new ArrayList<Lecture>();
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		

	
	
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://117.123.66.137:8089/lms", "park",
					"wldnjs7862"); 

			
			String query = "SELECT LectureID,LectureName,Hackjeom,currentNum,LimitNum, semester FROM lms.tlecture WHERE LteacherID=?;";
			conn = connection;
			pstmt = (PreparedStatement) conn.prepareStatement(query);
			
			pstmt.setString(1, UserID);
			rs = pstmt.executeQuery();
			
				System.out.println("내 강좌  userid"+UserID);
				myLectures.clear();
				  
				while (rs.next()) {
					 
					
					System.out.println(rs.getString("LectureName") +" " +rs.getString("LectureID"));
					Lecture lecture = new Lecture();
					
					lecture.setLectureID(rs.getInt("LectureID"));
					lecture.setLectureName(rs.getString("LectureName"));
					lecture.setSemester(rs.getString("semester"));
					lecture.setHackjeom(rs.getInt("Hackjeom"));
					lecture.setCurNum(rs.getInt("currentNum"));
					lecture.setLimitNum(rs.getInt("LimitNum"));
					
					myLectures.add(lecture);
				
					 
					

					
				}

			
				rs.close();
				pstmt.close();
				conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 
		}

	
		
		return myLectures;
		
		
	}

	
	
	public void InsertLecture( String userid,String lecture_name,int Hackjeom,int limitN, String semester) {
		// TODO Auto-generated method stub
		/* 수강신청 */
		
		System.out.println("강좌 등록");
		System.out.println(lecture_name+"   " +userid + " "+ semester);
		
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;

	
		try {

			Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection(
					"jdbc:mysql://117.123.66.137:8089/lms", "park",
					"wldnjs7862"); 

			//INSERT INTO `lms`.`tlecture` (`LectureName`, `LteacherID`, `Hackjeom`, `LimitNum`) VALUES ('"+Integer.parseInt(lectureID)+"','"+Integer.parseInt(userid)+"',' "+ lectureID+userid+"');
			//INSERT INTO `lms`.`tlecture` (`LectureName`, `LteacherID`, `Hackjeom`, `LimitNum`) VALUES ('데이터베이스', '23452345', '3', '30');
	
			stmt = conn.createStatement();
			
			String query = "INSERT INTO `lms`.`tlecture` (`LectureName`, `LteacherID`, `Hackjeom`, `LimitNum`,`semester`) VALUES ( '"+lecture_name+"','"+userid+"','"+Hackjeom+"','"+limitN+ "','"+ semester+"');";
			stmt.executeUpdate(query);
			 
				
			
			
				stmt.close();
				conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (stmt != null) {
					stmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  
		}
		 
	}
	
	public void deleteLecture(String lectureID, String userid) {
		// TODO Auto-generated method stub
		/* 수강신청 */
		
		System.out.println("강좌 삭제 "+ lectureID + " " +userid );
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
  
		try {

			Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection(
					"jdbc:mysql://117.123.66.137:8089/lms", "park",
					"wldnjs7862"); 

			
	
			stmt = conn.createStatement();
			
			String query ="DELETE FROM `lms`.`tlecture` where LteacherID= '"+userid + "' and LectureID='" +lectureID+ "';";
			stmt.executeUpdate(query);
			 
			
				stmt.close();
				conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (stmt != null) {
					stmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 
		}

		
		
		
		
	}



	public void updateLecture(String lectureID, String user_id) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Course> MyLectureStudentList(String lectureID, String user_id, String grade) {
		// TODO Auto-generated method stub
		System.out.println("수강생 목록  "+ user_id );
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		 ArrayList<Course> myCourses = new ArrayList<Course>();
		try {

			Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection(
					"jdbc:mysql://117.123.66.137:8089/lms", "park",
					"wldnjs7862"); 

			
			 String query ="SELECT  * FROM (lms.tstudent S JOIN lms.tlecture L ON S.SLectureID = L.LectureID)  JOIN lms.tuser U ON S.SID=U.userID where LteacherID= '"+user_id + "' and LectureID='" +lectureID+ "';";
			
			//String query ="select * from lms.tstudent S JOIN lms.tlecture L ON S.SLectureID = L.LectureID where LteacherID= '"+userid + "' and LectureID='" +lectureID+ "';";
			pstmt = (PreparedStatement) conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
				System.out.println("전체 과목 나열?");
				myCourses.clear();
				  
				while (rs.next()) {
					 
					
					System.out.println(rs.getString("LectureID") +" " +rs.getString("LectureName"));
					Course Course = new Course();
		
					
					Course.setName(rs.getString("userName"));
					Course.setLectureID(lectureID);
					Course.setSemester(rs.getString("semester"));
					Course.setUserID(rs.getString("userID"));
					Course.setMyHackjeom(rs.getString("SHJ"));
					Course.setLectureName(rs.getString("LectureName"));
					myCourses.add(Course);
				
					
					

					
				}

			
				rs.close();
				pstmt.close();
				conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}

				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 
		}
	

		return myCourses;
	}

	
}
