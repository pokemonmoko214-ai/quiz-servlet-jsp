<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String action = (String) session.getAttribute("action");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>クイズ</title>

<!-- Google Fonts（Hachi Maru Pop） -->

<link
	href="https://fonts.googleapis.com/css2?family=Kaisei+Tokumin:wght@700;800&display=swap"
	rel="stylesheet">

</head>

<body class="quiztop">

	<div>
		<h1 class="title">きらめき★Prism</h1>
	</div>

	<form action="QuizServlet" method="get">
		<input type="hidden" name="action" value="quiz">
		<button class="main-btn" type="submit">きらめきを集める</button>
	</form>


	<form action="GameSelectServlet" method="get">
		<button class="sub-btn" type="submit" name="action"
			value="<%=action == null ? "select" : ""%>">他のゲームで遊ぶ</button>

	</form>


</body>
</html>