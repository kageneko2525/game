package model;

import dao.BaseDao;
import dao.UserDao;

/**
 * ログイン判定クラス
 * @author ねこ
 *
 */
public class LoginLogic extends BaseDao {
	/**
	 * ログイン判定
	 * @param user ユーザークラス
	 * @return true:ログイン成功 false:ログイン失敗
	 */
	public boolean execute(User user) {
		UserDao dao = new UserDao();

		boolean isLogin = dao.findByIdAndHash(user);
		return isLogin;
	}

}
