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
</head>
<body>
<%if(loginUser==null){ %>
<%}else { %>
<p><%=loginUser.getUserName() %>さん</p>
<%} %>
	<section id ="menu">
		<div class ="menu__item">
			<a class ="menu__item--link" href="Index">ミニゲーム</a>
		</div>
		<div class ="menu__item">	
			<a class ="menu__item--link" href="Index">ランキング</a>
		</div>
		<div class ="menu__item">		
			<a class ="menu__item--link" href="Index">ショップ</a>
		</div>
		<div class ="menu__item">			
			<a class ="menu__item--link" href="Login">
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
<a href="#">TOPへ</p>
</div>
</footer>
</html>