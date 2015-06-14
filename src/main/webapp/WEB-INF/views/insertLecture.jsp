 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*"%>
    <%@page import="kr.ac.mju.park.LMS.model.*" %>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script> 

<title>강좌 등록 페이지</title>
</head>
<body>

<table>

<%
String sID = session.getAttribute("sessionUser").toString();
System.out.println("session ID " + sID);
%>


	<form action="${pageContext.request.contextPath}/LectureController/insertLecture" method="POST">
		
		<h2>강좌를 등록 하세요</h2>
		
		<tr>
		<input type="hidden" name="user_id" value=<%=sID%>>
		<td>강좌 이름</td><td><input type="text" name="lecture_name"></td>
		<td>학기</td><td><input type="text" name="lecture_semester"></td>
		<td>학점</td><td><select name = "Hackjeom"><option>1</option><option>2</option><option>3</option><option>4</option></select></td>
		<td>최대 수강인원 </td><td><input type="text" name="limitN" ></td>
		
		 <button type="submit" class="btn_insertCourse" >강좌 개설</button>
		</tr>
		
			
		
		
		
		
		
	</form>

	</table>
	
	</p>
<form action="${pageContext.request.contextPath}/LectureController/myLecturePage" method="get" >
		<input type="hidden" name="user_id" value=<%=sID%>>
		<button>내 강좌 목록</button>	<br />
		</form>	
	
 <form action="${pageContext.request.contextPath}/LoginController/main.do" method="get" >
		<input type="hidden" name="user_id" value=<%=sID%>>
		<button>메인화면으로</button>	<br />
		</form>	
</body>
</html>
<script type="text/javascript">

</script>
