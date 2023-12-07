/**
 * 登録処理
 * 製作者ねこ
 */

        document.addEventListener("DOMContentLoaded", function () {
            // テキスト入力時に呼び出される関数
            function checkInput(event) {
                // イベントが発生した要素からクラス名が "inputClass" のものを取得
                if (event.target.classList.contains("inputClass")) {
                    // ユーザーが入力したテキストを取得
                    var userInput = event.target.value;

                    // 文字数を取得
                    var charCount = userInput.length;

                    // 例: 文字数が制限を超えている場合にエラーメッセージを表示
                    var maxCharCount = 10; // 最大文字数
                    if (charCount > maxCharCount) {
                        document.getElementById("error").innerText = "文字数は" + maxCharCount + "文字以下にしてください";
                    } else {
                        document.getElementById("error").innerText = "";
                    }

                    // 他の検証ルールを追加することができます
                }
            }

            // クラス名が "form__inputText" の全ての input 要素に対してkeyupイベントを追加
            var inputElements = document.querySelectorAll(".form__inputText");
            inputElements.forEach(function (inputElement) {
                inputElement.addEventListener("keyup", checkInput);
            });
        });