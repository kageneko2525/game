package model;

import dao.BaseDao;
import dao.UserDao;

public class LoginLogic extends BaseDao {
	public boolean  execute(User user) {
		UserDao dao = new UserDao();
		
		boolean isLogin = dao.findByIdAndPassword(user);
		return isLogin;
	}

}
