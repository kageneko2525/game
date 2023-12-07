package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	 * @author ねこ
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
	
	
	/**
	 * 名前に一致する名前があるか
	 * @param user ユーザークラス NAMEを設定済みにしてね
	 * @return true:ある（すでに同じ名前の人がいる）false:いない
	 * @author ねこ
	 */
	public boolean findByName(String userName) {
		//Existence:存在
		boolean isExistence = false;

		try {

			this.connect();

			String sql = "SELECT user_id, user_name, hash "
					+ "FROM user "
					+ "WHERE user_name = ? ";
	

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
		
			if (rs.next()) {
				isExistence = true;
		
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
		
		return isExistence;
	}

	/**
	 * すべてのユーザー取得し、アレイリストに入れてもどす
	 * @return すべてのユーザーが入ったアレイリスト
	 * 			登録者０のときnull
	 * @author ねこ
	 */
	public ArrayList<User> findAllUser() {
		//ユーザーを入れるリスト
		ArrayList<User> userList = new ArrayList<User>();
		try {

			this.connect();

			String sql = "SELECT user_id, user_name, hash "
					+ "FROM user ";
	

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
		
			
			
			
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("user_id")) ;
				user.setUserName(rs.getString("user_name"));
				user.setHash("hash");
				userList.add(user);
			}
			return userList;
		} catch (Exception e) {
		
			e.printStackTrace();
		
		}finally {
	
			try {
			
				this.disConnect();
			
			} catch (SQLException e) {
			
				e.printStackTrace();
			
			}
		}
		
		return null;
	}

}
