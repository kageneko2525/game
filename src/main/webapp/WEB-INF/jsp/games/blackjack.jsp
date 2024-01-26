<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="model.Point" %>
	<%Point point = (Point)session.getAttribute("point");%>
	<%String gameStartError = (String)session.getAttribute("gameStartError");%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>game</title>
    <link rel="stylesheet" href="./css/blackjack.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<div id="game">
      <!--コンピューター  -->
    <div class ="com" >
            <p>ディーラー</p>
            <p id="comsum">0</p>
            <!-- コンピューターのカード -->
            <div class ="comCard">
                <img id ="com_1" src="./images/games/playing_cards/card_back.png" >
                <img src="./images/games/playing_cards/card_back.png" id="com_2">
                <img src="" id="com_3">
                <img src="" id="com_4">
                <img src="" id="com_5">
            </div>
    </div>
        <!-- プレイヤー -->
        <div class="player">
            <p>プレイヤー</p>
              <p id="playersum" class="playerInfo">0</p>  
              <p id="blackJack" class="playerInfo">ブラックジャック</p>
              <p id="brst" class="playerInfo">バースト</p>
            <!-- プレイヤーのカード -->
            <div class="playerCard">
                <img src="./images/games/playing_cards/card_back.png" id="player_1">
                <img src="./images/games/playing_cards/card_back.png" id="player_2">
                <img src="" id="player_3">
                <img src="" id="player_4">
                <img src="" id="player_5">
                <img src="" id="player_6">
                <img src="" id="player_7">
                <img src="" id="player_8">
            </div>
        </div>
        <!-- ゲームを行うボタンなど -->
        <div class="controller">
            <button id="stand">STAND</button>
            <button id="hit">HIT</button>
            <div class="dou">
                <button class="double">DOUBLE</button>
            </div>
		<form style="visibility: hidden;" id="form" action="Result"
			method="post">
			<input id="point" type="hidden" value="" name="score"> <input
				type="submit" value="結果を送信" id="endButton">
		</form>
        </div>
</div>
<h2 id="myPoint" style="visibility: hidden;">
		<%if (point == null) {%>
			0
		<%} else {%>
		<%=point.getPoint()%>
		<%}%>pt
</h2>
<script src="./js/blackjack.js"></script>
</body>
</html>