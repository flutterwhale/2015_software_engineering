<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="kr.ac.mju.park.LMS.model.*"%>
<%
	ArrayList<Course> myCourses = (ArrayList<Course>) request
			.getAttribute("MyCourses");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수강 내역 조회</title>
</head>
<body>

	<%
		String sID = session.getAttribute("sessionUser").toString();
		System.out.println("session ID " + sID);
	%>

	<h2>수강 내역 조회!!</h2>
	</br>

	<form
		action="${pageContext.request.contextPath}/CourseController/insertCoursePage"
		method="get">
		<button type="submit">수강신청 화면</button>

	</form>
	<form
		action="${pageContext.request.contextPath}/LoginController/main.do"
		method="get">
		<input type="hidden" name="user_id" value=<%=sID%>>
		<button>메인화면으로</button>
		<br />
	</form>

	<%
		if (myCourses.isEmpty()) {
	%>

	<h2>수강 신청 내역이 없습니다.</h2>
	<form
		action="${pageContext.request.contextPath}/CourseController/insertCoursePage"
		method="get">
		<button class="btn_registForCourse" type="submit">수강 신청</button>
	</form>
	<%
		System.out.println("수강 신청 내역이 없습니다.");
		} else {
	%>
	<table>
		<tr align="center">
			<td width="150">강좌명</td>
			<td width="150">교수</td>
			<td width="150">학기</td>
			<td width="120">나의 학점</td>
			
		</tr>
		<%
			for (Course c : myCourses) {
		%>
		<form
			action="${pageContext.request.contextPath}/CourseController/deleteCourse"
			method="post">
			<input type="hidden" name="course_id" value=<%=c.getID()%>> <input
				type="hidden" name="user_id" value=<%=sID%>> <input
				type="hidden" name="lecture_name" value=<%=c.getName()%>> <input
				type="hidden" name="hackjeom" value=<%=c.getHackjeom()%>>


			<tr align="center">
				<td width="150"><%=c.getName()%></td>

				<td width="150"><%=c.getTeacherName()%></td>
				<td width="150"><%=c.getSemester()%></td>
				<td width="120"><%=c.getMyHackjeom()%></td>
				
			</tr>


		</form>
		<%
			}
			}
		%>
	</table>
</body>
</html>