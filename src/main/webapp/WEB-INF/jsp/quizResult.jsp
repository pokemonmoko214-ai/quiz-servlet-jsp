<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Question"%>
<%@ page import="java.util.List"%>
<%
String action = (String) session.getAttribute("action");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
<meta charset="UTF-8">
<title>クイズ</title>
<link
	href="https://fonts.googleapis.com/css2?family=Kaisei+Tokumin:wght@700;800&display=swap"
	rel="stylesheet">

</head>
<body class="quizResult">

	<%
	Integer correctCount = (Integer) session.getAttribute("correctCount");
	//正解率
	int rate = (int) ((double) correctCount * 10); // 10問中なので10倍

	// ランク名の判定
	String rankName;
	if (rate == 100) {
		rankName = "✨ロイヤル・エターナル・ティアラ✨";
	} else if (rate >= 70) {
		rankName = "🌙プリンセス・スターライト🌙";
	} else if (rate >= 40) {
		rankName = "🎀マジカルライトリボン🎀";
	} else if (rate > 0) {
		rankName = "⭐おやすみスターライトメロディ⭐";
	} else {
		// 0点（
		rankName = "†ブラッディナイトメア†";
	}
	%>


	<div class="rank-title-area">
		<span class="rank-label">あなたのランク</span><br>
		<div class="rank-name"><%=rankName%></div>

	</div>
	</div>


	<div class="result-area">
		<span style="font-size: 30px;">集めたきらめきの数：<%=correctCount%>/10
		</span><br> <span style="font-size: 30px;">きらめき度：<%=rate%>%
		</span><br>

	</div>

	<div class="button-area">
		<form action="QuizServlet" method="get">
			<button type="submit" name="action" value="start">もう一度遊ぶ</button>
		</form>
		<%
		if (action == null) {
		%>
		<form action="GameSelectServlet" method="get">
			<input type="hidden" name="action" value="select">
			<button class="btn" type="submit">他のゲームで遊ぶ</button>
		</form>
		<%
		} else {
		%>
		<form action="GameSelectServlet" method="get">
			<input type="hidden" name="action" value="guest">
			<button class="btn" type="submit">他のゲームで遊ぶ</button>
		</form>
		<%
		}
		%>


	</div>

</body>
</html>
