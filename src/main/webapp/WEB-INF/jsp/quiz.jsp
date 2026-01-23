<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Question"%>
<%@page import="java.util.List"%>
<%
model.Question q = (model.Question) request.getAttribute("currentQuestion");
Integer index = (Integer) request.getAttribute("index");

if (q == null || index == null) {
	response.sendRedirect("quizServlet");
	return;
}
String[] choices = q.getChoice();
%>
<%
//正解数
int correctCount = 0;
if (session.getAttribute("correctCount") != null) {
	correctCount = (int) session.getAttribute("correctCount");
}
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>クイズ</title>

</head>
<body class="quiz">

	<!-- 正解数の星を表示 -->
	<div class="star-area fixed">
		集めたきらめき<br>
		<%
		for (int i = 0; i < correctCount; i++) {
		%>
		<span class="star"> ★ </span>
		<%
		if (i == 4) {
		%>
		<br>
		<%
		}
		%>
		<%}%>
	</div>
	<!--問題文表示<-->
	<h2>
		第<%=index + 1%>
		問

	</h2>
	<div class="question-area">

		<div class="question-text"><%=q.getQuestion()%></div>
	</div>
	<form action="QuizServlet" method="post">
		<%
		if (choices != null) {
			for (int i = 0; i < choices.length; i++) {
				String cls = "choice" + (i + 1);
		%>

		<button type="submit" name="answer" value="<%=i%>"
			class="choice-button <%=cls%>">
			<%=choices[i]%>
		</button>
		<%
		}
		%>
		<%
		}
		%>
	</form>
	<img src="images/quiz/unicorn.png" alt="ユニコーン" class="unicorn">

</body>
</html>
