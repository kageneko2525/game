package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.GamePoint;

public class GamePointDao extends BaseDao {

	public int setGame_Max_Point(GamePoint gamepoint) {

		try {
			this.connect();

			String sql = "UPDATE game_point set max_game_point="
					+ " where user_id=?"
					+ " and game_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, gamepoint.getUserId());
			ps.setInt(2, gamepoint.getGameId());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int max = rs.getInt("max_game_point");
				gamepoint.setMaxGamePoint(max);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				this.disConnect();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return gamepoint.getMaxGamePoint();
	}

}
