package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.GamePlay;

public class GamePlayDao extends BaseDao {

	
	/**
	 * ゲームプレイ表のインサート
	 * スタートは1　endは0に設定しとくよ
	 * @param gamePlay playid,gameidはセットしといてね
	 * @return true:成功 false:失敗
	 */
	public boolean gamePlaySetup(GamePlay gamePlay) {
		try {

			this.connect();
			
			String sql = "INSERT INTO game_play (play_id , game_id , start, end ) VALUES (?, ?, '1', '0')";

			PreparedStatement ps = con.prepareStatement(sql);


			ps.setString(1, Integer.toString(gamePlay.getPlayId()));
			ps.setString(2, Integer.toString(gamePlay.getGameId()));

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
	
	
	
	
	
	
	
}
