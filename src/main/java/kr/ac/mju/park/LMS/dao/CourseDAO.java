package kr.ac.mju.park.LMS.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kr.ac.mju.park.LMS.model.Course;

import org.springframework.stereotype.Repository;

@Repository
public class CourseDAO {
	public ArrayList<Course> getAllCourses() {
		// TODO Auto-generated method stub
		ArrayList<Course> allCourses = new ArrayList<Course>();
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://117.123.66.137:8089/lms", "park",
					"wldnjs7862"); 

			
			String query = "SELECT L.LectureID, L.LectureName, L.Hackjeom ,L.LteacherID,U.userName ,semester FROM lms.tlecture L join lms.tuser as U on L.LteacherID = U.userID;";
			conn = connection;
			pstmt = (PreparedStatement) conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
				System.out.println("전체 과목 나열?");
				allCourses.clear();
				  
				while (rs.next()) {
					 
					
					System.out.println(rs.getString("LectureID") +" " +rs.getString("LectureName"));
					Course course = new Course();
					
					course.setID(rs.getInt("LectureID"));
					course.setName(rs.getString("LectureName"));
					course.setHackjeom(rs.getInt("Hackjeom"));
					course.setTeacherName(rs.getString("userName"));
					course.setSemester(rs.getString("semester"));
					
					allCourses.add(course);
					
					
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

	
		
		return allCourses;
		
		
	}

	public ArrayList<Course> getMyCourses(String UserID) {
		// TODO Auto-generated method stub
		ArrayList<Course> myCourses = new ArrayList<Course>();
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
	
	
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://117.123.66.137:8089/lms", "park",
					"wldnjs7862"); 

			
			String query = "SELECT  SID, SLectureID,LectureName,LteacherID,userName as TeacherName,Hackjeom ,semester FROM (lms.tstudent S JOIN lms.tlecture L ON S.SLectureID = L.LectureID) JOIN lms.tuser U ON L.LteacherID=U.userID WHERE SID=?;";
			conn = connection;
			pstmt = (PreparedStatement) conn.prepareStatement(query);
			
			pstmt.setString(1, UserID);
			rs = pstmt.executeQuery();
			
				System.out.println("수강 과목 나열? userid "+UserID);
				myCourses.clear();
				  
				while (rs.next()) {
					 
					
					System.out.println(rs.getString("TeacherName") +" LectureName " +rs.getString("LectureName") +" SLectureID " +rs.getInt("SLectureID") + " " +
							
							" semester " +rs.getString("semester") + " Hackjeom " + rs.getInt("Hackjeom")
							
							);
					Course course = new Course();
					
					
					course.setID(rs.getInt("SLectureID"));
					course.setName(rs.getString("LectureName"));
					course.setHackjeom(rs.getInt("Hackjeom"));
					course.setSemester(rs.getString("semester"));
					course.setTeacherName(rs.getString("TeacherName"));
					
					myCourses.add(course);
				
					 
					
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

	public ArrayList<Course> getMyHackjeom(String UserID) {
		// TODO Auto-generated method stub
		ArrayList<Course> myCourses = new ArrayList<Course>();
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
	
	
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://117.123.66.137:8089/lms", "park",
					"wldnjs7862"); 

			
			String query = "SELECT  SID, SLectureID,LectureName,LteacherID,userName as TeacherName, SHJ as MyHJ , semester FROM (lms.tstudent S JOIN lms.tlecture L ON S.SLectureID = L.LectureID) JOIN lms.tuser U ON L.LteacherID=U.userID WHERE SID=?;";
			conn = connection;
			pstmt = (PreparedStatement) conn.prepareStatement(query);
			
			pstmt.setString(1, UserID);
			rs = pstmt.executeQuery();
			
				System.out.println("내 수강 학점? userid"+UserID);
				myCourses.clear();
				  
				while (rs.next()) {
					 
					
					System.out.println(rs.getString("TeacherName") +" " +rs.getString("LectureName"));
					Course course = new Course();
					
					course.setID(rs.getInt("SLectureID"));
					course.setName(rs.getString("LectureName"));
					course.setSemester(rs.getString("semester"));
					course.setMyHackjeom(rs.getString("MyHJ"));
					course.setTeacherName(rs.getString("TeacherName"));
					
					myCourses.add(course);
				
					 
					
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

	
	
	
	public void insertCourse(String courseID, String userid,String lecture_name) {
		// TODO Auto-generated method stub
		/* 수강신청 */
		
		System.out.println("수강 신청 ");
		System.out.println(lecture_name+"  "+ courseID + " " +userid );
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;

	
		try {

			Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection(
					"jdbc:mysql://117.123.66.137:8089/lms", "park",
					"wldnjs7862"); 

			//String query = "select * from " + "lms.tlecture";
			
	
			stmt = conn.createStatement();
			
			String query = "INSERT INTO `lms`.`tstudent` (`SLectureID`,  `SID`,`LIDSID`) VALUES ( '"+courseID+"','"+userid+"',' "+ courseID+userid+"');";
			stmt.executeUpdate(query);
			 
				
			
			
				stmt.close();
				conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			System.out.println("이미 신청한 과목입니다..");
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
	
	public void deleteCourse(String courseID, String userid) {
		// TODO Auto-generated method stub
		/* 수강신청 */
		
		System.out.println("수강 삭제 "+ courseID + " " +userid );
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
  
		try {

			Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection(
					"jdbc:mysql://117.123.66.137:8089/lms", "park",
					"wldnjs7862"); 

			
	
			stmt = conn.createStatement();
			
			String query ="DELETE FROM `lms`.`tstudent` where SID= '"+userid + "' and SLectureID='" +courseID+ "';";
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

	public void daoinsertHJ (String courseID, String user_id, String grade) {
		// TODO Auto-generated method stub
		
		
		System.out.println("학점 입력 ");
		System.out.println(courseID+"  "+ user_id + "  학점 " +grade );
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs1 = null;
		PreparedStatement pstmt = null;
		try {


			Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection(
					"jdbc:mysql://117.123.66.137:8089/lms", "park",
					"wldnjs7862"); 

		
			stmt = conn.createStatement();
			
			System.out.println(">>"+ user_id + "  "+ courseID + "  " + grade);
			
				
			
			String query2 = "SELECT tSNumber FROM (lms.tstudent S JOIN lms.tlecture L ON S.SLectureID = L.LectureID)  JOIN lms.tuser U ON S.SID=U.userID WHERE userID= '"+ user_id + "' and LectureID= '"+ courseID + "' ;";
			pstmt = (PreparedStatement) conn.prepareStatement(query2);
			

			rs1 = pstmt.executeQuery();
			

		
			while(rs1.next()){
				
				System.out.println(" 학생 테이블 ID  "+rs1.getInt("tSNumber"));
				
				String query = "UPDATE `lms`.`tstudent` SET `SHJ`='"+grade+"' WHERE `tSNumber`= '"+rs1.getInt("tSNumber")+"';";
				stmt.executeUpdate(query);
				 
					
				
			}
			
			
		
			
			
				stmt.close();
				conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		//	System.out.println("이미 신청한 과목입니다..");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs1 != null) {
					rs1.close();
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
}
