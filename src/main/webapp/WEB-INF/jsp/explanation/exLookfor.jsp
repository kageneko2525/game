<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script src="./js/game.js"></script>
<meta charset="UTF-8">
<title>エセガゲームランド</title>
</head>
<body>
	<h1>あいつをさがせ！</h1>
	<h2>ルール説明</h2>
	<p>画面上部に現れる画像を枠内から制限時間内に探し出せ！</p>
	<p>必要ポイント：１００</p>
	<form action="GameStart" method="post">
	<input type="hidden" name ="gameId" value="1">
	<input type="hidden" name ="levelId" value="1">
	<input type="submit" value="ゲームを開始">
	</form>
</body>
</html>