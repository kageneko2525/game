/**
 * 
 */

'use strict';
//表示する時間
const time = document.getElementById('time');
//ストップウォッチを開始した時の変数
let startTime;
//停止した時の変数（デフォルト値は0）
let stopTime = 0;
//経過した時間
let elapsedTime = 0;
//時間のカウントを止める際に必要な変数
let timeoutID;

let timer;

//時間を表示
function displayTime() {
	// 開始時間を現在の時刻に設定
	startTime = Date.now();
	// 時間計測
	measureTime();
}

// 時間を計測（再帰関数）
function measureTime() {
	// タイマーを設定
	timer = setTimeout(function() {
		// 経過時間を設定し、画面へ表示
		elapsedTime = Date.now() - startTime + stopTime;
		time.textContent = new Date(elapsedTime).toISOString().slice(14, 23);

		// 関数を呼び出し、時間計測を継続する
		measureTime();
	}, 10);
}

document.addEventListener('DOMContentLoaded', () => {
	class Card {
		constructor(suit, num) {
			//カードのスート
			this.suit = suit;
			//カードの数字
			this.num = num;
			//カードの画像
			this.front = `${suit}${num < 10 ? '0' : ''}${num}.png`;
		}
	}
	//カード一覧を代入する配列
	const cards = [];
	const suits = ['spade', 'diamond', 'heart', 'club'];
	//カード生成
	for (let i = 0; i < suits.length; i++) {
		for (let j = 1; j <= 13; j++) {
			let card = new Card(suits[i], j);
			cards.push(card);
		}
	}

	let firstCard = null;//1枚目のカード
	let secondCard = null;//2枚目のカード
	let pea = 0;//ペアになった組数
	let continuousPair = 0;//連続記録
	let continuousPairRecord = 0;//最大連続記録
	let incorrectAttempts = 0; // 間違えた試行回数
	let getPoint = 0;//獲得ポイント

	//結果を表示
	function result() {
		const end = document.getElementById('end');
		let div = document.createElement('div');
		div.textContent = '経過時間:' + elapsedTime +
			'\n最高連続正解数:' + continuousPairRecord +
			'\n間違えた回数:' + incorrectAttempts;
		end.append(div);
		getPoint = 50 * continuousPairRecord - incorrectAttempts;
		const pt = document.getElementById('pt');
		div = document.createElement('div');
		div.textContent = '獲得ポイント:' + getPoint;
		pt.append(div);
		view();
	}
	//カードをクリックした時の動き
	const flip = (eve) => {
		let div = eve.target;
		//既に表のカードと3枚目は選べないようにする
		if (!div.classList.contains('back') || secondCard !== null) {
			return;
		}
		//表面にする
		div.classList.remove('back');
		//1枚目のカードを代入
		if (firstCard === null) {
			firstCard = div;
			//2枚目のカードを代入
		} else {
			secondCard = div;
			//2枚のカードを判定
			if (firstCard.num === secondCard.num) {
				//揃っていたらクラスを付与
				firstCard.classList.add('fadeout');
				secondCard.classList.add('fadeout');
				//選んだカードを初期化
				[firstCard, secondCard] = [null, null];
				pea++
				continuousPair++;
				//最大連続記録の更新
				if (continuousPair > continuousPairRecord)
					continuousPairRecord = continuousPair;

				//全てペアになった時、タイマーを止め、結果を呼び出す
				if (pea == 26) {
					clearInterval(timer);
					stopTime += (Date.now() - startTime);
					result();
				}
			} else {
				//揃っていなければ表に戻す
				setTimeout(() => {
					firstCard.classList.add('back');
					secondCard.classList.add('back');
					//選んだカードを初期化
					[firstCard, secondCard] = [null, null];
				}, 1100);
				//間違えたら連続記録を0にする
				continuousPair = 0;
				incorrectAttempts++;
			}
		}
	};
	const cardgrid = document.getElementById('cardgrid');
	const initgrid = () => {
		cardgrid.textContent = null;
		for (let i = 0; i < suits.length; i++) {
			for (let j = 0; j < 13; j++) {
				let div = document.createElement('div');
				let card = cards[i * 13 + j];
				div.style.backgroundImage = `url(./images/games/cards/${card.front})`;
				div.classList.add('card', 'back');
				div.onclick = flip;
				//クリック時の挙動の判定
				div.num = card.num;
				cardgrid.append(div);
			}
		}
	};

	//カードをシャッフル
	const shuffle = () => {
		let i = cards.length;
		while (i) {
			let index = Math.floor(Math.random() * i--);
			[cards[index], cards[i]] = [cards[i], cards[index]]
		}
	};
	const startBt = document.getElementById('startBt');
	//ボタンを押した時の処理
	startBt.addEventListener('click', () => {
		startTime = Date.now();
		displayTime();
		shuffle();
		initgrid();
		//ゲーム開始時に選んだカードを初期化
		[firstCard, secondCard] = [null, null];
	});
});

function view() {
	let form = document.getElementById("form");
	let score = document.getElementById("score");

	score.value = getPoint / 10;
	form.style.visibility = "";
}