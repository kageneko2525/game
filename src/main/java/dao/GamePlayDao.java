package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.GamePlay;

public class GamePlayDao extends BaseDao {

	
	/**
	 * ゲームプレイ表のインサート
	 * スタートは1　endは0に設定しとくよ
	 * @param gamePlay playid,userId,gameidはセットしといてね
	 * @return true:成功 false:失敗
	 */
	public boolean gamePlaySetup(GamePlay gamePlay) {
		try {

			this.connect();
			
			String sql = "INSERT INTO game_play (play_id ,user_id , game_id , start, end ) VALUES (?, ?, ?, '1', '0')";

			PreparedStatement ps = con.prepareStatement(sql);


			ps.setString(1, Integer.toString(gamePlay.getPlayId()));
			ps.setString(2, Integer.toString(gamePlay.getUserId()));
			ps.setString(3, Integer.toString(gamePlay.getGameId()));

			gamePlay.setStart(1);
			gamePlay.setEnd(0);
			
			
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
	 * Gameplay表の中をすべてアレイリストでがえすよ
	 * @return アレイリスト
	 * @author ねこねこ
	 */
	
	public ArrayList<GamePlay> getAllGamePlay() {
		//ユーザーを入れるリスト
				ArrayList<GamePlay> gamePlayList = new ArrayList<GamePlay>();
				try {

					this.connect();

					String sql = "SELECT play_id,user_id, game_id, start , end"
							+ "FROM user ";

					PreparedStatement ps = con.prepareStatement(sql);

					ResultSet rs = ps.executeQuery();

					while (rs.next()) {
						GamePlay gamePlay = new GamePlay();
						gamePlay.setPlayId(rs.getInt("play_id"));
						gamePlay.setUserId(rs.getInt("user_id"));
						gamePlay.setGameId(rs.getInt("game_id"));
						gamePlay.setStart(rs.getInt("start"));
						gamePlay.setEnd(rs.getInt("end"));
						gamePlayList.add(gamePlay);
					}
					return gamePlayList;
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
