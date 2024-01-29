<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="./js/game.js"></script>
<link rel="stylesheet" href="./css/menu.css">
<link rel="stylesheet" href="./css/footer.css">
<link rel="stylesheet" href="./css/base.css">
<meta charset="UTF-8">
<title>エセガゲームランド</title>
</head>
<body>
<div id ="header">
<img id="header__image" alt="headerimage" src="./images/header.png">
<h1 id="header__title">エセガゲームランド</h1>
</div>

	<h1>あいつをさがせ！</h1>
	<h2>ルール説明</h2>
	<p>画面上部に現れる画像を枠内から制限時間内に探し出せ！</p>
	<p>必要ポイント：100pt</p>
	<form action="GameStart" method="post">
		<input type="hidden" name="gameId" value="1"> <input
			type="hidden" name="levelId" value="1"> <input type="submit"
			value="ゲームを開始">
	</form>
</body>
<footer>
<div id ="footer__back--white">
<a href="Index">TOPへ</a>
</div>
</footer>
</html>