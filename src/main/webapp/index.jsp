<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>

<link rel="stylesheet" href="css/style.css">
</head>
<body>
<h1 class="game-title">遊びたいゲームを選んでね！</h1>
	<div class="button-area2">
		<form action="QuizServlet" method="get">
			<input type="hidden" name="action" value="start">
			<button type="submit" class="yumekawa-btn">きらめき★Prism</button>
		</form>
		
		<form action="GameSelectServlet" method="get">
		<input type="hidden" name="action" value="game">
			<button type="submit" class="game-btn">ゲーム(準備中)</button>
		</form>
	</div>

</body>
</html>