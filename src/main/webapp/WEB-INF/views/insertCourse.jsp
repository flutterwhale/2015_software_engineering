<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="kr.ac.mju.park.LMS.model.*"%>
<% ArrayList<Course> allCourses  = (ArrayList<Course>)request.getAttribute("allCourses"); %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script> 

<title>수강 신청 페이지</title>
</head>
<body>
<h2>수강 신청 전체 목록</h2>
	</br>
<table>
		
<%
String sID = session.getAttribute("sessionUser").toString();
System.out.println("session ID " + sID);
%>


				<tr align="center">
					<td width="150"> 강좌명</td>
					<td width="120"> 학기 </td>
					<td width="200"> 교수</td>
					<td width="120"> 학점</td>
					
					<td width="100"> 수강 신청</td>
</tr>
 
	<% for(Course c : allCourses){ %>
	<form action="${pageContext.request.contextPath}/CourseController/insertCourse" method="post">
		<input type="hidden" name="course_id" value=<%=c.getID()%>>
		<input type="hidden" name="user_id" value=<%=sID%>>
		<input type="hidden" name="lecture_name" value=<%=c.getName()%>>
		<input type="hidden" name="hackjeom" value=<%=c.getHackjeom()%>>
		
		
			<tr align="center">
					<td width="150">  <%= c.getName() %></td>
						<td width="150">  <%= c.getSemester() %></td>
					<td width="200">  <%= c.getTeacherName() %></td>
					<td width="120">  <%= c.getHackjeom() %></td> 
					<td width="100">  <button class="btn_registForCourse" >수강 신청</button></td>
			</tr>
		
		
	</form>
	<% } %>
	</table>
	
	</p>
<form action="${pageContext.request.contextPath}/CourseController/checkCoursePage" method="get" >
		<input type="hidden" name="user_id" value=<%=sID%>>
		<button>수강 신청 목록</button>	<br />
		</form>	
	
 <form action="${pageContext.request.contextPath}/LoginController/main.do" method="get" >
		<input type="hidden" name="user_id" value=<%=sID%>>
		<button>메인화면으로</button>	<br />
		</form>	
</body>
</html>
<script type="text/javascript">

</script>
