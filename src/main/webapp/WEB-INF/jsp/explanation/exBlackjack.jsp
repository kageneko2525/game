<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	    <%@ page import ="model.Point" %>
	<%Point point = (Point)session.getAttribute("point");%>
	<%String gameStartError = (String)session.getAttribute("gameStartError");%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>ブラックジャック</title>
    <link rel="stylesheet" href="./css/exBlackjack.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<header>
    <h1>ブラックジャック</h1>
</header>
<body>
    
    <!-- ゲームスタートボタン -->
    <div class="gamestart">
        <form action="GameStart" method="post">
    		<input type="hidden" name="gameId" value="0">
    		<input type="hidden" name="levelId" value="1">
   			 <button type="submit">ゲームを開始</button>
		</form>
    </div>
    <!--遊び方  -->
  <div class="overlay" id="js-overlay"></div>
  <div class="modal" id="js-modal">

    <div class="modal-close__wrap">
      <button class="modal-close" id="js-close">
        <span></span>
        <span></span>
      </button>
    </div>

    <h2>基本ルール</h2>
    <p>
        ブラックジャックはディーラーとプレイヤーとの対戦型ゲームです<br>
        プレイヤーはディーラーよりもカードの合計が”21”に近ければ勝利です<br>
        なお手札の合計が”21”を超えるとバーストとなりその時点で負けになります<br>
        最初に配られた時点でプレイヤーの手札が”21”だった場合「ブラックジャック」となりその時点で勝利します<br>
        「ブラックジャック」時の配当は1.5倍されます<br>
        最初に配られた時点でプレイヤーは賭け金を２倍にできます。（ダブル）<br>
        その場合カードは1枚しか引けません。
    </p>
    <h2>カードの扱い</h2>
    <p>
        ・”2～9”はそのままの数字<br>
        ・”10,J,Q,K”はすべて”10”<br>
        ・”A”は”1”か”11”のどちらか選べます<br>
    </p>
    <h2>ゲームの進行</h2>
    <p>
        1,ディーラーからの『プレイスユアベット』（賭けてください）の合図でゲームがスタート。<br>
        2,ポイントを賭けてください。<br>
        3,ディーラーがカードを2枚配ります。<br>
        4,プレイヤーはヒット（カードを１枚追加）またはスタンド（手札の確定）を選択します<br>
        5,最後にディーラーがカードをめくり、17点以上になるまでカードを引き続け、勝負となります。<br>　ディーラーが21点以上になった場合は、ディーラーの負けになります<br>
        6,ディーラーよりも21点に近いプレイヤーは勝ちとなり、賭け金と同額の配当を得ることができます。<br>
        　逆にディーラーよりも21点に遠いプレイヤーは負けとなり、賭け金は没収されます。<br>
        　なお、同点の場合はプッシュといい、引き分けとなります。
       
        
    </p>
  </div>
  <!-- 遊び方ボタン -->
<div class="howToPlay">
  <button class="modal-open" id="js-open">遊び方</button>
</div>
<!-- JQuery -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="./js/exBlackjack.js"></script>
    
    <!-- 戻るボタン -->
    <div class="back">
        <button>戻る</button>
    </div>
    <!-- 所持ポイント表示 -->
    <div class="point">
        <h1>所持ポイント</h1>
		<h2>
<%if(point == null ){ %>
	0
<%}else{ %>
<%=point.getPoint() %>
<%} %>
pt
		</h2>
	</div>
</body>
</html>