<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%String loginError = (String)session.getAttribute("loginError");%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/menu.css">
<link rel="stylesheet" href="./css/footer.css">
<link rel="stylesheet" href="./css/logo.css">
<meta charset="UTF-8">
<title>エセガゲームランド</title>
</head>
<body>
<div id ="header">
<img id="header__image" alt="headerimage" src="./images/header.png">
</div>
<%if(loginError!=null){ %>
<p style="color: red;">※<%=loginError %></p>
<%} %>
	<form action="Login" method="post">
	ユーザー名<input type="text" name="userName"><br>
	パスワード<input type="password" name="pass">
	<input type="submit"value="送信">
	</form>
	<a href="Index">戻る</a>　　<a href="Registration">新規登録</a>
</body>
<footer>
<div id ="footer__back--white">
<a href="Index">TOPへ</a>
</div>
</footer>
</html>