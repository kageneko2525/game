package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.GamePoint;

public class GamePointDao extends BaseDao {

	/**
	 * ゲームポイントを設定するよ
	 * ユーザーid　ゲームID　LEVELidを設定したgamePointを渡してね
	 * @param gamePoint 
	 * @return true:成功 false:失敗
	 */
	public boolean setGamePoint(GamePoint gamePoint) {
		try {

			this.connect();

			String sql = "INSERT INTO game_point (user_id ,game_id , level_id, max_game_point) VALUES (?, ?, ?, ?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, gamePoint.getUserId());
			ps.setInt(2, gamePoint.getGameId());
			ps.setInt(3, gamePoint.getLevelId());
			ps.setInt(4, 0);

			ps.executeUpdate();
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
	 * 獲得最大ポイントを更新するよ
	 * ユーザーIDゲームIDレベルIDポイントをセットして送ってね
	 * @param gamePoint
	 * @return trer:成功 aflse:そっぱい
	 */
	public boolean updatePoint(GamePoint gamePoint) {
		boolean isUpdate = false;

		try {
			this.connect();

			String sql = "UPDATE game_point set max_game_point = ? "
					+ " where user_id = ? and game_id = ? and level_id = ? ";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, gamePoint.getMaxGamePoint());
			ps.setInt(2, gamePoint.getUserId());
			ps.setInt(3, gamePoint.getGameId());
			ps.setInt(4, gamePoint.getLevelId());

			int tmp = ps.executeUpdate();

			if (tmp>0) {

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

	/**
	 * すべてのゲームポイント表をアレイリストで送る
	 * @return
	 */
	public ArrayList<GamePoint> getAllGamePoint() {

		ArrayList<GamePoint> gamePoints = new ArrayList<GamePoint>();

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
	 * 最大ゲームポイントを返す
	 * @return
	 */
	public GamePoint getGamePoint(GamePoint gamePoint) {


		try {

			this.connect();

			String sql = "SELECT max_game_point FROM game g ,game_point gp , user u ,use_point up "
					+ "WHERE gp.user_id = u.user_id "
					+ "AND gp.game_id = g.game_id "
					+ "AND gp.game_id = up.game_id "
					+ "AND u.user_id = ? "
					+ "AND g.game_id = ? "
					+ "AND up.level_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, gamePoint.getUserId());
			ps.setInt(2, gamePoint.getGameId());
			ps.setInt(3, gamePoint.getLevelId());
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				gamePoint.setMaxGamePoint(rs.getInt("max_game_point"));
				return gamePoint;
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

		return null;

	}
	
	/**
	 * ゲームIDを指定して検索
	 * @param gameId
	 * @return
	 */
	public ArrayList<GamePoint> getSelectGamePoint(int gameId) {

		ArrayList<GamePoint> gamePoints = new ArrayList<GamePoint>();

		try {

			this.connect();

			String sql = "SELECT u.user_name, gp.max_game_point "
					+ "	FROM game_point gp , user u , game g  "
					+ "		WHERE gp.user_id = u.user_id  "
					+ "			AND g.game_id = gp.game_id "
					+ "			AND g.game_id = ? "
					+ "		ORDER BY max_game_point DESC  "
					+ "		LIMIT 10 ";

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

	/**
	 * 
	 * ユーザーID、ゲームID、レベルIDを指定して存在するか検索
	 * ゲームポイントに入れて送ってね
	 * 
	 * @param gameId
	 * @return trer:そんざいする　false ;しない
	 */
	public boolean findSelectGamePoint(GamePoint gamePoint) {

		try {

			this.connect();

			String sql = "SELECT max_game_point FROM game g ,game_point gp , user u ,use_point up "
					+ "WHERE gp.user_id = u.user_id "
					+ "AND gp.game_id = g.game_id "
					+ "AND gp.game_id = up.game_id "
					+ "AND u.user_id = ? "
					+ "AND g.game_id = ? "
					+ "AND up.level_id = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, gamePoint.getUserId());
			ps.setInt(2, gamePoint.getGameId());
			ps.setInt(3, gamePoint.getLevelId());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				gamePoint.setMaxGamePoint(rs.getInt("max_game_point"));
				return true;
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

		return false;

	}

}
