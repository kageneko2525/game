package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
/**
 * user表のDAO
 * @author ねこ
 *
 */
public class UserDao extends BaseDao {
 
	/**
	 * IDとハッシュに一致する名前があるか
	 * IDをセットします
	 * @param user ユーザークラス ID,NAMEを設定済みにしてね
	 * @return true:ある（ログイン成功）false:ない(ログイン失敗)
	 */
	public boolean findByIdAndHash(User user) {

		boolean isLogin = false;

		try {

			this.connect();

			String sql = "SELECT user_id, user_name, hash "
					+ "FROM user "
					+ "WHERE user_name = ? "
					+ "AND hash = ? ";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, user.getUserName());
			ps.setString(2, user.getHash());
			ResultSet rs = ps.executeQuery();
		
			if (rs.next()) {
				int id = rs.getInt("user_id");
				user.setUserId(id);
				isLogin = true;
		
			}

		} catch (Exception e) {
		
			e.printStackTrace();
		
		}finally {
	
			try {
			
				this.disConnect();
			
			} catch (SQLException e) {
			
				e.printStackTrace();
			
			}
		}
		
		return isLogin;
	}
	
	
}
