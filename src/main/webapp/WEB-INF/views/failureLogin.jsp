<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="kr.ac.mju.park.LMS.model.UserInfo" %>
		<%@ page import ="kr.ac.mju.park.LMS.model.User" %>
		<%
		
	//UserInfo ui = (UserInfo)session.getAttribute("userinfo");
	
		String code =  request.getAttribute("code").toString();	
		

	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Page</title>
</head>
<body>

<% if (code.equals("111")){ %>

	<script type="text/javascript">  alert("환영합니다.");	 </script>

<%}else if(code.equals("101")) { %>

<script type="text/javascript">  alert("code 101 : 존재하지 않는 ID 입니다.");	
location.replace("${pageContext.request.contextPath}/LoginController/logout.do");   


</script>

<%}else if(code.equals("112")) {%>
<script type="text/javascript">  alert("code 112 : 비밀번호가 일치 하지 않습니다.");location.replace("${pageContext.request.contextPath}/LoginController/logout.do");   	 </script>



<%}else if(code.equals("201")){ %>
<script type="text/javascript">  alert("code 201 : 회원 가입에 실패하였습니다.");
location.replace("${pageContext.request.contextPath}/LoginController/logout.do");   	 </script>

<% 
}
%>

		
					<script type="text/javascript"> 
				alert("회원 가입 성공! 로그인 해주세요.");
				location.replace("${pageContext.request.contextPath}/LoginController/logout.do");
				 
				
				</script>


</body>
</html>