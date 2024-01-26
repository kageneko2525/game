//ここから変数

//コンピュータのカードを表示させるためのDOM
let com1 = document.getElementById('com_1');
let com2 = document.getElementById("com_2");
let com3 = document.getElementById("com_3");
let com4 = document.getElementById("com_4");
let com5 = document.getElementById("com_5");
//コンピュータの合計を表示させるためのDOM
let comsum = document.getElementById("comsum");

//プレイヤーのカードを表示させるためのDOM
let player1 = document.getElementById("player1");
let player2 = document.getElementById("player2");
let player3 = document.getElementById("player3");
let player4 = document.getElementById("player4");
let player5 = document.getElementById("player5");
//プレイヤーのカードの合計を表示させるためのDOM
let playerSum = document.getElementById("playersum");
//プレイヤーのブラックジャック、バースト表示のためのDOM
let showBlackJack = document.getElementById("blackJack");
let showBrst = document.getElementById("brst");
//ボタンをいじるためのDOM
let doubleButton = document.querySelector(".double");
let standButton = document.getElementById("stand");
let hitButton = document.getElementById("hit");
let homeButton = document.getElementById("home");

//プレイヤーの手札を決めるための数字(1~52)
let playerHandNum;
//プレイヤーの手札の配列
let playerHand = [];
//プレイヤーの引いたカードの柄
let playerPattern;
//プレイヤーがバーストしたかどうか
let playerBrst = false;
//プレイヤーがブラックジャックかどうか
let playerBlackjack = false;
//最終的なプレイヤーの合計
let sumPhand =0;

//コンピューターの手札を決めるための数字(1~52)
let comHandNum;
//コンピューの手札の配列
let comHand = [];
//コンピューターのひいたカードの柄
let comPattern;
//コンピューターがバーストしてるかどうか
let comBrst = false;
//コンピューターがブラックジャックかどうか
let comBlackjack = false;
//最終的なコンピューターの合計
let sumChand =0;

//掛け金
let bet;
//結果の文章
let resultSentence;
//山札
let yama = [];

let origin;
let getPoint;

//ここまで変数

//ベットさせるよ
while (true) {
    bet = prompt("いくらベットしますか");
    if (!bet || isNaN(bet)) {// 入力が空白または数字以外の場合は再度入力
        alert("有効な整数を入力してください。");
    } else {
        break;//整数入力されたんで抜ける
    }
    origin = bet;
}
//山札作成
for (i = 0; i < 52; i++){
    yama[i] = (i+1);
}

//初期手札
first();
function first (){
    //コンピューターの初期手札を配る
    //数字の割り振り
    comHandNum = drow();
    //割り振られた数字から引いたカードの柄を決める
    comPattern = decidePattern(comHandNum);
    //割り振られた数字から引いたカードの実際に使う数字に変換する
    comHandNum = decideNum(comPattern,comHandNum);
    //引いたカードの保存
    comHand.push(comHandNum);
    //引いたカードからコンピューターのカードの画像を変える
    changeImg(com1,comPattern,comHandNum);
    //コンピューターのカードの合計を計算
    sumComHand();

    //プレイヤーの初期手札を配る
    for(i = 0; i < 2; i++){//プレイヤーの初期手札は二枚
        //数字の割り振り
        playerHandNum = drow();
        //割り振られた数字から引いたカードの柄を決める
        playerPattern = decidePattern(playerHandNum);
        //割り振られた数字から実際に使われる数字に変換する
        playerHandNum = decideNum( playerPattern,playerHandNum);
        //プレーヤーの手の保存
        playerHand.push(playerHandNum);
        //プレイヤーのカードの場所を決める
        let wh = "player_" + (i+1);
        let playerElement = document.getElementById(wh);
        //画像を変える
        changeImg(playerElement,playerPattern,playerHandNum);
        //プレイヤーのカードの合計を計算する
        sumPlayerHand();
    }
}
//ドロー
function drow (){
    let num;
    do {
        //変数numに1~52の数字を代入
        num = Math.floor(Math.random() * 52 +1);
    }while(yama[num] == null);//代入した数字が山札の配列になかったらやり直す
    //カードの重複を避けるため山札から引いた数字を消す
    yama[num] = null;
    return num
}

//柄の決定
function decidePattern (num) {
    let pattern;
    if(num < 14){//1～13のときはダイヤ
        pattern = "ダイヤ";    
    }else if(num < 27){//14~26のときはクラブ
        pattern = "クラブ";
    }else if(num < 40){//27~39のときはハート
        pattern = "ハート";
    }else {//40~52のときはスペード
        pattern = "スペード";
    }
    return pattern
}
//数字の変換
function decideNum (pattern,num) {
    if(pattern == "クラブ"){
        num = (num - 13);
    }else if(pattern =="ハート"){
        num = (num - 26); 
    }else if(pattern == "スペード"){
        num = (num - 39);
    }
    return num
}

//画像の変更
function changeImg(where,pat,num){
    if(pat == "ダイヤ"){
        where.src = "./images/games/playing_cards/diamond/card_diamond_0"+num+".png";
    }else if(pat == "クラブ"){
        where.src = "./images/games/playing_cards/club/card_club_0"+num+".png";
    }else if(pat == "ハート"){
        where.src = "./images/games/playing_cards/heart/card_heart_0"+num+".png";
    }else if(pat == "スペード"){
        where.src = "./images/games/playing_cards/spead/card_spade_0"+num+".png";
    }
}

//ヒット
hit.addEventListener("click", function() {
    //ダブルはできなくなるのでボタンを消す
    doubleButton.style.display = "none";
    //カードを引く
    playerDrow();
})
//スタンド
stand.addEventListener("click", function(){
    //ダブルはできなくなるのでボタンを消す
    doubleButton.style.display = "none";
    //コンピューターのターンに
    comDrow();
})

//ダブル
doubleButton.addEventListener("click", function() {
    double();
    //ダブルはできなくなるのでボタンを消す
    doubleButton.style.display = "none";
    //コンピューターのターンに
    comDrow();
});
function double(){
    bet = bet * 2;//ダブルのときはbetが二倍に
    playerDrow();
}
//プレイヤードロー
function playerDrow(){
    //数字の割り振り
    playerHandNum = drow(); 
    //割り振られた数字から引いたカードの柄を決める
    playerPattern = decidePattern(playerHandNum); 
     //割り振られた数字から実際に使われる数字に変換する
    playerHandNum = decideNum( playerPattern,playerHandNum); 
    //プレーヤーの手の保存
    playerHand.push(playerHandNum); 
    //画像変更
    let wh = "player_" + playerHand.length;
    let playerElement = document.getElementById(wh);
    changeImg(playerElement,playerPattern,playerHandNum);
    //プレイヤーの手の計算
    sumPlayerHand();
    //プレイヤーがブラックジャック、バーストかどうかをチェックする
    cheakPlayer(sumPhand);
    //プレイヤーがブラックジャック、バーストの場合、ゲームが終わる
    if(playerBrst == true || playerBlackjack == true){
        result();
    }
}

//プレイヤー手札合計計算
function sumPlayerHand(){
    if(playerHand[playerHand.length - 1] > 9){//10以上の手なら一律で10に変換
        sumPhand = sumPhand + 10;
    }else if(playerHand[playerHand.length - 1] == 1 && (sumPhand + 11) < 22){
            //1のときかつ今の手に11を加えたときにバーストしないのであれば11に変換
        sumPhand = sumPhand + 11;
    }else {
        sumPhand = sumPhand + playerHand[playerHand.length - 1];//あとはそのまま
    }
    //プレイヤーの手の合計を更新する
    playerSum.innerHTML = sumPhand;
}
//コンピューター手札合計
function sumComHand(){
    if(comHand[comHand.length -1] > 9){//10以上の手なら一律で10に変換
        sumChand = sumChand + 10;
    }else if(comHand[comHand.length - 1] == 1 && (sumChand + 11) < 22){
            //1のときかつ今の手に11を加えたときにバーストしないのであれば11に変換
        sumChand = sumChand + 11;
    }else {//あとはそのまま
        sumChand = sumChand + comHand[comHand.length - 1];
    }
    //コンピューターの手を更新する
    comsum.innerHTML = sumChand;
}

//プレイヤーチェック
function cheakPlayer(sum){
    if(sum > 21){//合計が22以上のときはplayerBrstをtrueに
        playerBrst = true;
        //バーストの文字の出現
        showBrst.style.display = "block";
    }else if(sum == 21){//合計が21のときはplayerBlackJackをtrueに
        playerBlackjack = true;
        //ブラックジャックの文字の出現
        showBlackJack.style.display = "block";
    }
}
//コンピューターチェック
function cheakCom(num){
    if(num > 21){//合計が22以上のときはcomBrstをtrueに
        comBrst = true;
    }else if(num == 21){//合計が21のときはcomBlackJackをtrueに
        comBlackjack = true;
    }
}
//コンピュータのドロー
function comDrow(){
    do {
        //数字の割り振り
        comHandNum = drow();
        //割り振られた数字から引いたカードの柄を決める
        comPattern = decidePattern(comHandNum);
         //割り振られた数字から実際に使われる数字に変換する
        comHandNum = decideNum(comPattern,comHandNum);
        //コンピュータの手の保存
        comHand.push(comHandNum);
        //画像の変更
        let wh = "com_" + comHand.length;
        let comElement = document.getElementById(wh);
        changeImg(comElement,comPattern,comHandNum);
        //コンピューターの手の計算
        sumComHand();
    } while (sumChand < 17);//コンピューターの手の合計が17以上になるまで繰り返す
    //ブラックジャック、バーストのチェック
    cheakCom(sumChand);
    //結果表示
    result();
}

//結果判定
function result(){
    if(playerBrst == true){//プレイヤーがバーストしているとき
        resultSentence = "あなたの負け";
        bet = 0;//負けたので配当は０
    }else if(comBrst == true){//コンピューターがバーストしたとき
        resultSentence = "あなたの勝ち";
    }else if(playerBlackjack == true){//プレイヤーがブラックジャックのとき
        resultSentence = "あなたの勝ち"
        bet = (bet * 1.5);//ベット1.5倍
    }else if(sumChand < sumPhand){//プレイヤーのほうが大きいとき
        resultSentence = "あなたの勝ち";
    }else {//それ以外
        resultSentence = "あなたの負け";
        bet = 0;//負けたので０
    }
    //スタンド。ヒット無効化
    standButton.disabled = true;
    hitButton.disabled = true;
    //2秒後に結果を表示
    setTimeout(function() {
        showResult();
        getPoint = origin + bet;
        console.log(getPoint)
        document.getElementById("point").value = getPoint;
        document.getElementById("form").submit();
        //タイトルボタンを表示する
        homeButton.style.display = "block";
      }, 2000);
}
//アラートで結果を表示
function showResult() {
    alert("あなたの手:" + sumPhand + "\nコンピュータの手:" + sumChand + "\n結果:" + resultSentence+ "\n配当:"+bet);
}


