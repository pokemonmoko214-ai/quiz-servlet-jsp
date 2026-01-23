<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Question"%>
<%@page import="java.util.List"%>

<%
// ★ request ではなく session から取得する
List<Question> questions = (List<Question>) session.getAttribute("questions");
Integer index = (Integer) session.getAttribute("index");

// index は doPost の最後で +1 されているので、1つ戻す
int showIndex = index - 1;

Question q = questions.get(showIndex);
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


<script>
	// 2秒後に次の問題へ
	setTimeout(function() {
		window.location.href = "QuizServlet";
	}, 1500);
</script>

</head>
<body class="quiz">

	<!-- 正解数の星を表示 -->
	<div class="star-area fixed">
		集めたきらめき<br>
		<%
		for (int i = 0; i < correctCount; i++) {
		%>
		<span class="star">★</span>
		<%
		if (i == 4) {
		%>
		<br>
		<%
		}
		%>
		<%}%>
	</div>
	<!-- 赤丸 -->
	<div class="correct-mark">〇</div>

	<!-- 問題文 -->
	<h2>
		第<%=index%>
		問

	</h2>

	<div class="question-area">
		<div class="question-text"><%=q.getQuestion()%></div>
	</div>

	<!-- 選択肢（押せないように disabled を付けるとより自然） -->
	<form>
		<%
		for (int i = 0; i < choices.length; i++) {
			String cls = "choice" + (i + 1);
		%>
		<button type="button" class="choice-button <%=cls%>" disabled>
			<%=choices[i]%>
		</button>
		<%
		}
		%>
	</form>
	<img src="images/quiz/unicornok.png" alt="ユニコーン" class="unicorn">
</body>
</html>