<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학사관리 메인</title>
</head>
<body>
</br>
<h4>
<strong>Lecture Management System!</strong>
	</h4>


	
	</br>
	</br>

	<table>
		<form
			action="${pageContext.request.contextPath}/LoginController/login.do"
			method="POST">

			<tr>
				<td width="70">ID :</td>
				<td width="150"><input type="text" name="user_id"></td>
			</tr>
			<tr>
				<td width="70">PW :</td>
				<td width="150"><input type="password" name="user_password"></td>

			</tr>
			<tr>
				<td width="70">
					<button type="submit">로그인</button>
		</form>
		</td>
		<td><form
				action="${pageContext.request.contextPath}/LoginController/signupPage"
				method="POST">

				<button type="submit">회원 가입</button>
			</form></td>
		</tr>



	</table>
<p>네트워크 사정에 따라, 페이지이동과 쿼리가 늦게 작동 할 수 있습니다.</p>
</body>
</html>