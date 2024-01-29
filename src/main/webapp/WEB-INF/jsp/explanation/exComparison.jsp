<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="./js/game.js"></script>
<meta charset="UTF-8">
<title>エセガゲームランド</title>
 <link rel="stylesheet" href="./css/exComparison.css">
</head>
<body>
	<h1>神経衰弱</h1>
	<p>1回:100pt</p>
	<p>連続正解と少ないミスが高得点の秘訣！お前の記憶力を見せてみろ！</p>
	<form action="GameStart" method="post">
		<input type="hidden" name="gameId" value="2"> <input
			type="hidden" name="levelId" value="1"> <input type="submit"
			value="ゲームを開始" class="button">
	</form>
</body>
</html>