<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%String registrationError = (String)session.getAttribute("registrationError");%>
<!DOCTYPE html>
<html>
<head>
<script src="./js/registration.js"></script>
<meta charset="UTF-8">
<title>エセガゲームランド</title>
</head>
<body>
<%if(registrationError!=null){ %>
<p style="color: red;">※<%=registrationError %></p>
<%} %>
	<form action="Registration" method="post">

		ユーザー名 <input type="text" id="form__inputText1" name="registrationName"><br>
		<div id="error1" style="color: red;"></div>
		パスワード<input type="password" id="form__inputText2" name="pass"><br>
		<div id="error2" style="color: red;"></div>
		パスワード再入力<input type="password" id="form__inputText3" name="samePass">
		<div id="error3" style="color: red;"></div>
		<input id="form--button" type="submit" value="送信">
	</form>
	<a href="Index">Topへ</a>　　<a href="Login">ログイン画面へ</a>　　
</body>
</html>