<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% Int getPoint = (Int)request.getAttribute("getPoint") %>
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
<h1>結果発表</h1>
<p><%=getPoint %>ポイント獲得しました！！！</p>
<a href="/Index">ゲーム選択へ</a>

</body>
<footer>
<div id ="footer__back--white">
<a href="Index">TOPへ</a>
</div>
</footer>
</html>