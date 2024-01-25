<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="./js/game.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>神経衰弱</h1>
	<p>必要ポイント：１００</p>
	<form action="GameStart" method="post">
		<input type="hidden" name="gameId" value="3"> <input
			type="hidden" name="levelId" value="1"> <input type="submit"
			value="ゲームを開始">
	</form>
</body>
</html>