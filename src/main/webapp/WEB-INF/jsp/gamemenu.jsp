<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	    <%@ page import ="model.Point" %>
	<%Point point = (Point)session.getAttribute("point");%>
	<%String gameStartError = (String)session.getAttribute("gameStartError");%>
<!DOCTYPE html>
<html>
<head>
<style>
.box {
	display: flex;
	justify-content: space-around;
	align-items: center;
}

.gameBox {
	text-align: center;
	border: 1px black solid;
}
</style>
<meta charset="UTF-8">
<title>エセガゲームランド</title>
<link rel="stylesheet" href="./css/gamemenu.css">
<link rel="stylesheet" href="./css/footer.css">
</head>
<header>
	<h1>ミニゲーム一覧</h1>
	<h2>所持ポイント: 

<%if(point != null ){ %>
	<%=point.getPoint() %>
<%}else{ %>
0
<%} %>
pt
</h2>
</header>
<body>

<%if(gameStartError!=null&&gameStartError!=""){ %>
<p style="color: red;">※<%=gameStartError %></p>
<%} %>
	<main>
		<div class="box">
			<div class="gameBox">
				<p></p>
				<a href=""><img src="" alt=""></a>
			</div>
			<div class="gameBox">
				<p>あいつをさがせ！</p>
				<a href="Explanation?game=Lookfor"><img src="./images/gameImg/sample_lookfor.png" alt=""></a>
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