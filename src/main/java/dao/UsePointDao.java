package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.UsePoint;

public class UsePointDao extends BaseDao {

	/**
	 * ゲーム開始に必要なポイントを取得
	 * @param gameId ゲームのID 
	 * @param levelId 難易度のID
	 * @return 数値:必要なポイント -1:そんなゲームor難易度ないよ
	 */
	public int getUsePoint(int gameId, int levelId) {
		int usePoint = -1 ;
		try {
		
			this.connect();
			
			String sql = "select use_point "
					+"from use_point "
					+"where game_id = ? "
					+"and level_id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,gameId);
			ps.setInt(2, levelId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				usePoint = rs.getInt("use_point");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		finally {
			try {

				this.disConnect();

			} catch (SQLException e) {

				e.printStackTrace();

			}
		}
		
		
		return usePoint;
	}
	
	
	/**
	 * ゲーム開始に必要なポイントを取得
	 * usepointに必要ポイント入れて返すよ
	 * @param usePoint usepointのDTOにIDいれてね 
	 * @return ture:成功　false:失敗
	 */
	public boolean getUsePoint(UsePoint usePoint) {

		try {
		
			this.connect();
			
			String sql = "select use_point "
					+"from use_point "
					+"where game_id = ? "
					+"and level_id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,usePoint.getGameId());
			ps.setInt(2, usePoint.getLevelId());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				usePoint.setUsePount(rs.getInt("use_point")); 
				return true;
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		finally {
			try {

				this.disConnect();

			} catch (SQLException e) {

				e.printStackTrace();

			}
		}
		
		
		return false;
	}
	
	
}
