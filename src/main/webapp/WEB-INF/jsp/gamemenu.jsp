<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	    <%@ page import ="model.Point" %>
	<%Point point = (Point)session.getAttribute("point");%>
	<%String gameStartError = (String)session.getAttribute("gameStartError");%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/menu.css">
<link rel="stylesheet" href="./css/footer.css">
<link rel="stylesheet" href="./css/gamemenu.css">
<link rel="stylesheet" href="./css/base.css">

<meta charset="UTF-8">
<title>エセガゲームランド</title>
</head>


</header>
<body>
	<div id="header">
		<img id="header__image" alt="headerimage" src="./images/header.png">
		<h1 id="header__title">エセガゲームランド</h1>
	</div>
		<h1>ミニゲーム一覧</h1>
	<h2>所持ポイント: 

<%if(point == null ){ %>
	0
<%}else{ %>
<%=point.getPoint() %>
<%} %>
pt
</h2>
<%if(gameStartError!=null&&gameStartError!=""){ %>
<p style="color: red;">※<%=gameStartError %></p>
<%} %>
	<main>
		<div class="box">
			<div class="gameBox">
				<p>神経衰弱</p>
				<a href="Explanation?game=Comparison"><img src="./images/gameImg/sample_comparison.png" alt=""></a>
			</div>
			<div class="gameBox">
				<p>あいつをさがせ！</p>
				<a href="Explanation?game=Lookfor"><img src="./images/gameImg/sample_lookfor.png" alt=""></a>
			</div>
			<div class="gameBox">
				<p>ブラックジャック</p>
				<a href="Explanation?game=Blackjack"><img src="./images/gameImg/sanmple_blackjack.png" alt="" id="blackjack"></a>
			</div>
			<div class="gameBox">
				<p></p>
				<a href=""><img src="" alt=""></a>
			</div>
		</div>
	</main>
</body>
<footer>
	<div id="footer__back--white">
		<a href="Index">TOPへ</a>
	</div>
</footer>
</html>