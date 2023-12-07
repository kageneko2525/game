		function changeButton() {
			let button = document.getElementById("form--button");
			button.type = "button"
			button.value = "送信できません"
		}

		function changeSubmit() {
			let button = document.getElementById("form--button");
			button.type = "submit"
			button.value = "送信"
		}

		document.addEventListener("DOMContentLoaded", function () {
			// テキスト入力時に呼び出される関数
			function checkInputUserName() {
				// ユーザーが入力したテキストを取得
				var userInput = document.getElementById("form__inputText1").value;
				if (userInput != "") {
					// 正規表現を使用して検証
					var pattern = /^[a-zA-Z0-9_]+$/;

					// 例: 正規表現に一致しない場合にエラーメッセージを表示
					if (!pattern.test(userInput)) {
						document.getElementById("error1").innerText = "大文字、小文字の英字、数字、アンダースコアのみ使用できます ";
						changeButton()
					} else if (userInput.length > 16) {
						document.getElementById("error1").innerText = "ユーザー名は16文字までです";
						changeButton()
					} else {
						document.getElementById("error1").innerText = "";
						changeSubmit()
					}
				} else {
					document.getElementById("error1").innerText = "";
					changeSubmit()
				}
				// 他の検証ルールを追加することができます
			}
			// input要素に対してinputイベントを追加
			document.getElementById("form__inputText1").addEventListener("input", checkInputUserName);
		});


		document.addEventListener("DOMContentLoaded", function () {
			// テキスト入力時に呼び出される関数
			function checkInputPass() {
				// ユーザーが入力したテキストを取得
				var userInput = document.getElementById("form__inputText2").value;
				if (userInput != "") {
					// 正規表現を使用して検証
					var pattern = /^[a-zA-Z~`!@#$%^&*()-_+=]+$/;

					// 例: 正規表現に一致しない場合にエラーメッセージを表示
					if (!pattern.test(userInput)) {
						document.getElementById("error2").innerText = "使用できない文字が含まれています";
						changeButton()
					} else {
						document.getElementById("error1").innerText = "";
						changeSubmit()
					}

				} else {
					document.getElementById("error2").innerText = "";
					changeSubmit()
				}
				// 他の検証ルールを追加することができます
			}
			// input要素に対してinputイベントを追加
			document.getElementById("form__inputText2").addEventListener("input", checkInputPass);
		});


		document.addEventListener("DOMContentLoaded", function () {
			// テキスト入力時に呼び出される関数
			function checkInputSamePass() {
				// ユーザーが入力したテキストを取得
				var userInput1 = document.getElementById("form__inputText2").value;
				var userInput2 = document.getElementById("form__inputText3").value;
				if (userInput2 != "") {

					// パスワードが一致しないときエラー表示
					if (userInput1 != userInput2) {
						document.getElementById("error3").innerText = "パスワードが一致しません";
						changeButton()
					} else {
						document.getElementById("error3").innerText = "";
						changeSubmit()
					}

				} else {
					document.getElementById("error3").innerText = "";
					changeSubmit()
				}
				// 他の検証ルールを追加することができます
			}
			// input要素に対してinputイベントを追加
			document.getElementById("form__inputText3").addEventListener("input", checkInputSamePass);
		});