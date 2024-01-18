<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ page import ="model.User" %>
<% User loginUser = (User)session.getAttribute("loginUser"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>エセガゲームランド</title>

<link rel="stylesheet" href="./css/menu.css">
<link rel="stylesheet" href="./css/footer.css">
<link rel="stylesheet" href="./css/base.css">
<link rel="stylesheet" href="./css/index.css">
</head>
<body>
<div id ="header">
<img id="header__image" alt="headerimage" src="./images/header.png">
<h1 id="header__title">エセガゲームランド</h1>
</div>


<%if(loginUser==null){ %>
<%}else { %>
<p>ようこそ、<%=loginUser.getUserName() %>さん</p>
<%} %>
	<section id ="menu">
		<div class ="menu__item">
			<a class ="menu__item--link" href="Gamemenu">ミニゲーム</a>
		</div>
		<div class ="menu__item">	
			<a class ="menu__item--link" href="Ranking">ランキング</a>
		</div>
		<div class ="menu__item">		
			<a class ="menu__item--link" href="Index">ショップ</a>
		</div>
		<div class ="menu__item">
			<%if(loginUser==null){ %>
			<a class ="menu__item--link" href="Login">ログイン</a>
			<%}else { %>
			<a class ="menu__item--link" href="Logout">ログアウト</a>
			<%} %>
		</div>
	</section>
</body>
<footer>
<div id ="footer__back--white">
<a href="Index">TOPへ</a>
</div>
</footer>
</html>