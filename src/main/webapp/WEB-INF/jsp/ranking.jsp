<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>

<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/menu.css">
<link rel="stylesheet" href="./css/ranking.css">
<link rel="stylesheet" href="./css/base.css">
<link rel="stylesheet" href="./css/footer.css">

<meta charset="UTF-8">
<title>エセガゲームランド</title>
</head>
<body>
	<div id="header">
		<img id="header__image" alt="headerimage" src="./images/header.png">
		<h1 id="header__title">エセガゲームランド</h1>
	</div>

	<button id="gameId" onclick="fetchUserData('0')">0</button>
	<button id="gameId" onclick="fetchUserData('1')">1</button>



	<table id="userDataContainer">
		<tr>
			<td>順位</td>
			<td>ユーザー名</td>
			<td>ポイント</td>
		</tr>
		<tr >
			<td colspan="3">ボタンを押してランキングを表示</td>
		</tr>
	</table>
	<script src="./js/ranking.js"></script>
</body>
<footer>
	<div id="footer__back--white">
		<a href="Index">TOPへ</a>
	</div>
</footer>
</html>