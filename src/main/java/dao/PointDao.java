package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Point;

public class PointDao extends BaseDao {

	/**
	 * 
	 * @return
	 */
	public Point findPoint() {
		
		return null;
	}

	public int setPoint(Point point ) {
		try {
			this.connect();
			
			String sql = "UPDATE point set point=point+" 
			+ " where user_id=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			
			
			//PointLogicでゲームで獲得したポイントを入れる変数作ってここにセット
			ps.setInt(1, );
			ps.setInt(2, point.getUserId());
			
			//PointLogicでゲーム結果とショップどちらで減るのか分かる変数作ってif文の条件に入れる(多分色々変わる)
			if() {
			point.setSumPoint();
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
		return point.getPoint();
	}
}
