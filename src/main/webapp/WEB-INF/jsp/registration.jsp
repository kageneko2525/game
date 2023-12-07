<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Registration" method="post">

		ユーザー名 <input type="text" id="form__inputText1" name="userName"><br>
		<div id="error1" style="color: red;"></div>
		パスワード<input type="password" id="form__inputText2" name="pass1"><br>
		<div id="error2" style="color: red;"></div>
		パスワード再入力<input type="password" id="form__inputText3" name="pass2">
		<div id="error3" style="color: red;"></div>
		<input id="form--button" type="submit" value="送信">

	</form>
	</form>
</body>
</html>