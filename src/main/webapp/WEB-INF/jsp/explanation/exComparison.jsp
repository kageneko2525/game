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
	<h2>ルール説明</h2>
	<p>並べられたカードを同じ数字で揃えろ！ミスは最終結果に響くぞ！連続正解を狙え！！</p>
	<p>必要ポイント：１００</p>
	<form action="GameStart" method="post">
		<input type="hidden" name="gameId" value="2"> <input
			type="hidden" name="levelId" value="2"> <input type="submit"
			value="ゲームを開始">
	</form>
</body>
</html>