package model;

import dao.BaseDao;
import dao.PointDao;

/**
 * ポイント加算クラス
 * @author エセガ
 *
 */

public class PointLogic extends BaseDao {
	/**
	 * 所持ポイントの加算判定
	 * @return true:加算成功 false:加算失敗
	 * @author エセガ
	 */
	public boolean execute(Point point) {
		PointDao pointDao = new PointDao();

		boolean isPoint = pointDao.updatePoint(point);
		return isPoint;
	}

}
