<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="kr.ac.mju.park.LMS.model.*"%>
<%
	ArrayList<Course> myStudents = (ArrayList<Course>) request.getAttribute("MyStudents");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학생 리스트/성적 조회</title>
</head>
<body>

	<%
		String sID = session.getAttribute("sessionUser").toString();
		System.out.println("session ID " + sID);
	%>

	<h2>학생 리스트/성적 조회</h2>
	</br>


	<form
		action="${pageContext.request.contextPath}/LoginController/main.do"
		method="get">
		<input type="hidden" name="user_id" value=<%=sID%>>
		<button>메인화면으로</button>
		<br />
	</form>

	<%
		if (myStudents.isEmpty()) {
	%>

	<h2>해당 강좌의 수강생이 없습니다.</h2>
	
	<%
		System.out.println("해당 강좌의 수강생이 없습니다.");
		} else {
	%>
	<table>
		<tr align="center">
			<td width="150">학생ID</td>
			<td width="150">학생 이름</td>
			<td width="150">성적</td>
			<td width="150">성적입력</td>
			
			
		</tr>
		<%
			for (Course c : myStudents) {
		%>
		<form action="${pageContext.request.contextPath}/CourseController/insertHackjeom" method="post">
			<input type="hidden" name="teacher_id" value=<%=sID%>>
<input type="hidden" name="courseID" value=<%= c.getLectureID()%>>
<input type="hidden" name="user_id" value= <%= c.getUserID() %>>

			<tr align="center">
					<td width="150">  <%= c.getUserID() %>   </td>
					<td width="150">  <%= c.getName()%> </td>
					
					<td width="150">  <%= c.getMyHackjeom() %></td>
					<td width="150"><select id="hj" name = "insertHJ"><option>A+</option><option>A0</option><option>B+</option><option>B0</option><option>C+</option><option>C0</option><option>D+</option><option>D0</option><option>F</option></select>
					<button type="submit" class="btn_insertHackjeom" >성적 입력</button></td>
				
				
			</tr>


		</form>
		<%
			}
			}
		%>
	</table>
</body>
</html>