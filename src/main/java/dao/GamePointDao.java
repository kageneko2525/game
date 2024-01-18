package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.GamePoint;

public class GamePointDao extends BaseDao {

	public boolean updateGame_Max_Point(GamePoint gamepoint) {
		boolean isUpdate = false;

		try {
			this.connect();

			String sql = "UPDATE game_point set max_game_point=?"
					+ " where user_id=?"
					+ " and game_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, 0);
			ps.setInt(2, gamepoint.getUserId());
			ps.setInt(3, gamepoint.getGameId());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int max = rs.getInt("max_game_point");
				gamepoint.setMaxGamePoint(max);
				isUpdate = true;
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
		return isUpdate;
	}

	public boolean setGame_Max_Point(GamePoint gamepoint) {
		try {
			this.connect();

			String sql = "INSERT INTO game_point(user_id,game_id,max_game_point)VALUES(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, gamepoint.getUserId());
			ps.setInt(2, gamepoint.getGameId());
			ps.setInt(3, gamepoint.getMaxGamePoint());
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				this.disConnect();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;

	}
	
	
	
	/**
	 * すべてのゲームポイント表をアレイリストで送る
	 * @return
	 */
	public ArrayList<GamePoint> getAllGamePoint() {
		
		ArrayList<GamePoint>  gamePoints = new ArrayList<GamePoint>();
		
		try {

			this.connect();

			String sql = "SELECT u.user_name,g.max_game_point FROM game_point g , user u "
					+ "	WHERE g.user_id = u.user_id "
					+ "	ORDER BY max_game_point DESC "
					+ "	LIMIT 10;";

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				GamePoint gamePoint = new GamePoint();
				gamePoint.setUserName(rs.getString("user_name"));
				gamePoint.setMaxGamePoint(rs.getInt("max_game_point"));
				gamePoints.add(gamePoint);
			}
			return gamePoints;
		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				this.disConnect();

			} catch (SQLException e) {

				e.printStackTrace();

			}
		}

		return null;
		
		
	}
	
	/**
	 * ゲームIDを指定して検索
	 * @param gameId
	 * @return
	 */
	public ArrayList<GamePoint> getSelectGamePoint(int gameId) {
		
		ArrayList<GamePoint>  gamePoints = new ArrayList<GamePoint>();
		
		try {

			this.connect();

			String sql = "SELECT u.user_name, gp.max_game_point\r\n"
					+ "	FROM game_point gp , user u , game g \r\n"
					+ "		WHERE gp.user_id = u.user_id \r\n"
					+ "			AND g.game_id = gp.game_id\r\n"
					+ "			AND g.game_id = 1\r\n"
					+ "		ORDER BY max_game_point DESC \r\n"
					+ "		LIMIT 10";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, gameId);
			ResultSet rs = ps.executeQuery();


			while (rs.next()) {
				GamePoint gamePoint = new GamePoint();
				gamePoint.setUserName(rs.getString("user_name"));
				gamePoint.setMaxGamePoint(rs.getInt("max_game_point"));
				gamePoints.add(gamePoint);
			}
			return gamePoints;
		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				this.disConnect();

			} catch (SQLException e) {

				e.printStackTrace();

			}
		}

		return null;
		
		
	}
	
}
