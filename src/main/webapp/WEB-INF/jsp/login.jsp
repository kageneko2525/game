<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="Login" method="post">
	ユーザー名<input type="text" name="userName"><br>
	パスワード<input type="password" name="pass">
	<input type="submit"value="送信">
	</form>
	<a href="Index">戻る</a>　　　<a href="Registration">新規登録</a>
</body>
</html>