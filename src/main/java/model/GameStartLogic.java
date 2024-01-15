package model;

import dao.PointDao;
import dao.UsePointDao;

public class GameStartLogic {

	/**
	 * ゲームと難易度が存在するかチェック
	 * @param gameId ゲームID
	 * @param levelId 難易度ID
	 * @return true:存在する false:存在しない
	 */
	public boolean checkGameLevel(int gameId, int levelId) {
		UsePointDao usePointDao = new UsePointDao();
		if (usePointDao.getUsePoint(gameId, levelId) > 0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 必要なポイントに十分なポイントを所持しているか
	 * pointにUserIdを格納しとくよ
	 * @param user ログインユーザー
	 * @param gameId ゲームID
	 * @param levelId 難易度ID
	 * @param point ユーザーのポイント格納用
	 * @return true：十分なポイントがある false：十分なポイントがない
	 */
	public Boolean checkEnoughPoint(User user, int gameId, int levelId, Point point) {
		//pointテーブル検索用
		PointDao pointDao = new PointDao();
		UsePointDao usePointDao = new UsePointDao();
		point.setUserId(user.getUserId());
		if (pointDao.getPoint(point)) {

		} else {
			//エラーだねえ

			return false;
		}

		return point.getPoint() - usePointDao.getUsePoint(gameId, levelId) >= 0;

	}
	
	
	
	
	
	
	
	
	
	
}










