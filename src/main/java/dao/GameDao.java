package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Game;

public class GameDao extends BaseDao{

	
	/**
	 * IDに一致するゲーム名とパスを返します
	 * gameにGameIDをセットしてから使ってください
	 * @param game ゲーム
	 * @return Game:検索ヒット null:なかった
	 */
	public Game getGameByGameId(Game game) {
				
				try {

					this.connect();

					String sql = "SELECT game_id,game_name, game_path "
							+ "FROM game "
							+ "where game_id = ? ";

					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, game.getGameId());

					ResultSet rs = ps.executeQuery();

					if (rs.next()) {
						game.setGameName(rs.getString("game_name"));
						game.setGamePath(rs.getString("game_path"));

					}
					return game;
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
