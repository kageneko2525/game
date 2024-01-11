/**
 * 
 */


// ---------変数----------
let timer
let score = 0
let divTimer = document.getElementById("timer")
let divImageBox = document.getElementById("imagesBox")
let divScore = document.getElementById("score")
let imageQuestion = document.getElementById("questionImage")
let bottenStrat = document.getElementById("button__stratButton")
let pTimer
let mikujis


// 難易度
let difficulty
let index

let num

let images = [
	"./images/lookfor/mayupen.png",
	"./images/lookfor/nakinoko.png",
	"./images/lookfor/nekotan.png",
	"./images/lookfor/obake.png",
	"./images/lookfor/okoribana.png",
	"./images/lookfor/rariboshi.png"
]

let choiceImage = []

// --------関数------------
function startTimer() {
	//タイマー初期化
	timer = 10

	// ゲームセット
	gameMain()

	//pタグ生成
	pTimer = document.createElement("p")
	pScore = document.createElement("p")


	// タグに文字設定
	pTimer.textContent = timer
	pScore.textContent = score

	// pタグをdivに追加
	divTimer.appendChild(pTimer)
	divScore.appendChild(pScore)

	// 開始ボタン非表示
	bottenStrat.style.display = "none";

	// カウントダウン開始
	timerID = setInterval(() => timerDown(), 1000)
}


function timerDown() {
	//タイマーが０以上なら
	if (timer > 0) {

		// 時間を減らして表示
		timer--

		pTimer.textContent = timer

	} else {

		// ０以下ならタイマー停止
		clearInterval(timerID)

		let point = document.getElementById("point")
		let form = document.getElementById("form")
		form.style.visibility = ""
		point.value = score

		divImageBox.textContent = ""
	}
}

function gameMain() {
	selectQuestionImage()

	createImages()

	addImagea()
}

//難易度による数の設定
function imageNum() {
	num = 150
}

function selectQuestionImage() {
	index = Math.floor(Math.random() * images.length)
	let imagesrc = images[index]
	imageQuestion.src = imagesrc


}

// 間違い画像配列生成
function createImages() {
	imageNum()
	choiceImage = []


	for (let i = 0; i < images.length; i++) {
		if (i != index) {
			choiceImage.push(images[i])
		}
	}



}

function addImagea() {
	imageArray = new Array(num).fill(null);

	for (let i = 0; i < imageArray.length; i++) {
		imageArray[i] = document.createElement("img")
		let rand = Math.floor(Math.random() * choiceImage.length)


		imageArray[i].src = choiceImage[rand]

		let randomX = Math.floor(Math.random() * (divImageBox.offsetWidth) * 0.95) + 10
		let randomY = Math.floor(Math.random() * (divImageBox.offsetHeight) * 0.87) + 230

		imageArray[i].style.left = `${randomX}px`
		imageArray[i].style.top = `${randomY}px`
		divImageBox.appendChild(imageArray[i])


	}

	let qImage = document.createElement("img")
	qImage.src = images[index]
	let queu_X = Math.floor(Math.random() * (divImageBox.offsetWidth) * 0.95) + 10

	let queu_Y = Math.floor(Math.random() * (divImageBox.offsetHeight) * 0.87) + 230


	qImage.style.left = `${queu_X}px`
	qImage.style.top = `${queu_Y}px`
	divImageBox.appendChild(qImage)
	qImage.onclick = function() {
		clickQuestionImage()
	}
	let rand = Math.random() * 4

	for (let i = 0; i < rand; i++) {
		let imgEle = document.createElement("img")
		let src = choiceImage[Math.floor(Math.random() * choiceImage.length)]
		imgEle.src = src

		let x = Math.random() * 10 + 6
		let y = Math.random() * 10 + 6

		if (Math.random() < 0.5) {
			imgEle.style.left = `${queu_X + x}px`
		} else {
			imgEle.style.left = `${queu_X - x}px`
		}

		if (Math.random() < 0.5) {
			imgEle.style.top = `${queu_Y + y}px`
		} else {
			imgEle.style.top = `${queu_Y - y}px`
		}

		imgEle.style.zIndex = imgEle.style.zIndex + 4
		divImageBox.appendChild(imgEle)
	}
}


function clickQuestionImage() {
	divImageBox.innerHTML = ""
	scoreUp()
	timeUp()
	gameMain()
}




function scoreUp() {
	score++
	pScore.textContent = "POINT : " + score

}

function timeUp() {
	timer += 5
	pTimer.textContent = timer
}