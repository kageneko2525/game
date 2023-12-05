package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDao extends BaseDao {
 
	public boolean findByIdAndPassword(User user) {

		boolean isLogin = false;

		try {

			this.connect();

			String sql = "SELECT id, name, hash "
					+ "FROM user "
					+ "WHERE id = ? "
					+ "AND hash = ? ";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, user.getUserId());
			ps.setString(2, user.getHash());
			ResultSet rs = ps.executeQuery();
		
			if (rs.next()) {
				String name = rs.getString("name");
				user.setUserName(name);
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
