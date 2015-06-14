<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="kr.ac.mju.park.LMS.model.*"%>
    <% ArrayList<Lecture> myLectures  = (ArrayList<Lecture>)request.getAttribute("MyLectures"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내 강좌 조회</title>
</head>
<body>

<%
String sID = session.getAttribute("sessionUser").toString();
System.out.println("session ID " + sID);
%>

<h2> 내 강좌 조회 </h2>
</br>

<form action="${pageContext.request.contextPath}/LectureController/insertLecturePage" method="POST" >
		<input type="hidden" name="user_id" value=<%=sID%>>
		<button>강좌 개설하기</button>	<br />
		</form>

</form>
 <form action="${pageContext.request.contextPath}/LoginController/main.do" method="get" >
		<input type="hidden" name="user_id" value=<%=sID%>>
		<button>메인화면으로</button>	<br />
		</form>	
	
	<% 
	
	
	if(myLectures.isEmpty()){
		
		
		%>
		
		<h2>등록된 강좌가 없습니다.</h2>
		<form action="${pageContext.request.contextPath}/LectureController/insertLecturePage" method="POST" >
		<input type="hidden" name="user_id" value=<%=sID%>>
		<button>강좌 개설하기</button>	<br />
		</form>
		<% 
		System.out.println("등록된 강좌가 없습니다.");
	}else{
		%>
		<table>
		<tr align="center">
		<td width="150"> 강좌ID</td>
		<td width="150"> 강좌명</td>
		<td width="150"> 학기</td>
		<td width="150"> 학점</td>
		<td width="150"> 현재 인원</td>
		<td width="120"> 최대 인원</td>
		<td width="150"> 성적 입력</td>
		<td width="150"> 강좌 삭제</td>
		</tr>
	<%
	for(Lecture c : myLectures){ %>
		
		
		
		 <tr align="center">
					<td width="150">  <%= c.getLectureID() %></td>
					
					<td width="150">   <%= c.getLectureName() %></td>
					<td width="150">   <%= c.getSemester() %></td>
					<td width="120">  <%= c.getHackjeom() %></td> 
					<td width="120">  <%= c.getCurNum() %></td> 
					<td width="120">  <%= c.getLimitNum() %></td> 
					<td width="150">  
			
			  <form action="${pageContext.request.contextPath}/LectureController/showStudentPage" method="GET">
			  <input type="hidden" name="lecture_id" value=<%=c.getLectureID()%>>
		<input type="hidden" name="user_id" value=<%=sID%>>
		
			  	
					<button class="btn_insertgrade" type="submit" >학생 목록</button></td>
					</form>
			</td><td width="150">
			
					<form action="${pageContext.request.contextPath}/LectureController/deleteLecture" method="post">
					<input type="hidden" name="lecture_id" value=<%=c.getLectureID()%>>
		<input type="hidden" name="user_id" value=<%=sID%>>
		
					<button class="btn_registForLecture" type="submit" >강좌 삭제</button></td>
					</form>
			</tr> 
		
			
	
	<% } }%>
	</table>
</body>
</html>