<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/lookfor.css">
<title>あいつをさがせ！</title>
</head>
<body>
	<main>

		<div id=timer></div>
		<div id="score"></div>
		<button id="button__stratButton" onclick="startTimer()">ゲームを開始</button>
		<form style="visibility: hidden;" id="form" action="Result"
			method="post">
			<input id="point" type="hidden" value="" name="score"> <input
				type="submit" value="結果を送信" id="endButton">
		</form>
		<div id="questionBox">
			<img id="questionImage" src="">
		</div>
		<div id="imagesBox"></div>

	</main>


	<script src="./js/lookfor.js"></script>
</body>
</html>