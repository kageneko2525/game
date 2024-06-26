<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String registrationError = (String) session.getAttribute("registrationError");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/menu.css">
<link rel="stylesheet" href="./css/footer.css">
<link rel="stylesheet" href="./css/base.css">

<script src="./js/registration.js"></script>
<meta charset="UTF-8">
<title>エセガゲームランド</title>
</head>
<body>
	<div id="header">
		<img id="header__image" alt="headerimage" src="./images/header.png">
		<h1 id="header__title">エセガゲームランド</h1>
	</div>
	<%
	if (registrationError != null) {
	%>
	<p style="color: red;">
	<%
	}
	%>
	<form action="Registration" method="post">

		ユーザー名 <input type="text" id="form__inputText1" name="registrationName"><br>
		<div id="error1" style="color: red;"></div>
		メールアドレス<input type="email" name="mail"><br>
		パスワード<input type="password" id="form__inputText2" name="pass"><br>
		<div id="error2" style="color: red;"></div>
		パスワード再入力<input type="password" id="form__inputText3" name="samePass">
		<div id="error3" style="color: red;"></div>
		<input id="form--button" type="submit" value="送信">
	</form>
	<a href="Index">Topへ</a>
	<a href="Login">ログイン画面へ</a>
</body>
</html>