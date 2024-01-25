<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="./js/game.js"></script>
<meta charset="UTF-8">
<title>神経衰弱</title>
  <link rel="stylesheet" href="./css/comparison.css">
</head>

<body>
  <p>経過時間　<div id="time">00:00.000</div></p>
   <input type="button" value="START" id="startBt" onclick="style.display='none'">
   <div id="cardgrid"></div>
   <div id="end"></div>
   <div id="pt"></div>
   <script src="./js/comparison.js"></script>


  <form action="Result" method="post" style="visibility: hidden;" id="form">
  <input id="score" type="hidden" value="" name="score">
  <input type="submit" id="send"></form>
</body>

</html>