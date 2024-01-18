// ranking.js

function fetchUserData(gameId) {
    // Ajaxリクエストを使用してランキングデータを取得
    $.ajax({
        url: 'Ranking', // サーブレットのパス
        method: 'POST',
        data: { gameId: gameId },
        success: function(response) {
            // 取得したランキングデータを表示する
            var rankingContainer = $('#userDataContainer');
            rankingContainer.empty(); // 既存のデータをクリア

            // 各ユーザーデータに対してHTML要素を生成して追加
            response.forEach(function(entry, index) {
                rankingContainer.append((index + 1) + '. User: ' + entry.userName + ', Points: ' + entry.point + '<br>');
            });
        },
        error: function(error) {
            console.log('エラーが発生しました:', error);
        }
    });
}
