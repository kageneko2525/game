package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Point;
import model.UsePoint;
import model.User;

public class PointDao extends BaseDao {
	
	
	
	
	
	

	/**
	 * 現在ログインしているユーザーの所持ポイントを取得
	 * ポイントを格納して返すよ
	 * @param point ポイント格納用
	 * @return true:取得成功　false:取得失敗
	 * @author エセガ
	 */
	public boolean getPoint(Point point) {
		boolean isPoint = false;
		try {

			this.connect();

			String sql = "SELECT user_id, point , sum_point "
					+ "FROM point "
					+ "WHERE user_id = ? ";

			PreparedStatement ps = con.prepareStatement(sql);

			//いまログインしてる人のIDをここに入れたいけどどうやって入れればいいか分からん
			//とりあえず今はpoint表のuserId入れてる
			ps.setInt(1, point.getUserId());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				point.setSumPoint(rs.getInt("sum_point"));
				point.setPoint(rs.getInt("point"));
				isPoint = true;
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
		return isPoint;
	}
	
	
	
	
	
	
	
	

	/**
	 * 
	 *現在ログインしているユーザーの総獲得ポイントを取得
	 * @return true:取得成功　false:取得失敗
	 * @author エセガ
	 */
	public boolean getSumPoint(Point point) {
		boolean isSumPoint = false;
		try {

			this.connect();

			String sql = "SELECT user_id, sum_point "
					+ "FROM point "
					+ "WHERE user_id = ? ";

			PreparedStatement ps = con.prepareStatement(sql);

			//いまログインしてる人のIDをここに入れたいけどどうやって入れればいいか分からん
			//とりあえず今はpoint表のuserId入れてる
			ps.setInt(1, point.getUserId());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int sum = rs.getInt("sum_point");
				point.setSumPoint(sum);
				isSumPoint = true;
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
		return isSumPoint;
	}

	/**
	 * ゲームで獲得したポイントを所持ポイントに加算
	 * pointにUserId,pointを格納しといてね
	 * 加算減算できるよ！
	 * @return true:加算成功　false:加算失敗
	 * @author エセガ
	 */

	public boolean updatePoint(Point point) {
		boolean isUpdate = false;

		try {
			this.connect();

			String sql = "UPDATE point set point=point+?"
					+ " where user_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			//いまログインしてる人のIDをここに入れたいけどどうやって入れればいいか分からん
			//とりあえず今はpoint表のuserId入れてる
			ps.setInt(1, point.getPoint());
			ps.setInt(2, point.getUserId());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int poi = rs.getInt("point");
				point.setPoint(poi);
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
 * 現在のポイントを更新するよ
 * ゲーム開始時に使ってね
 * pointはuserId point,usePointはusePointを設定しておいてね
 * pointに使った後のポイントに更新されるよ
 * @param point
 * @param usePoint
 * @return treu:成功 false;失敗
 * @author おれ
 */
	public boolean updatePoint(Point point , UsePoint usePoint) {
		boolean isUpdate = false;

		try {
			this.connect();

			//仮置きです！
			int tmp= point.getPoint() - usePoint.getUsePount();
			
			
			String sql = "UPDATE point set point= ? "
					+ " where user_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			point.setPoint(tmp);
			
			
			//いまログインしてる人のIDをここに入れたいけどどうやって入れればいいか分からん
			//とりあえず今はpoint表のuserId入れてる
			ps.setInt(1, tmp);
			ps.setInt(2, point.getUserId());
			int rowsUpdated = ps.executeUpdate();

			if (rowsUpdated>0) {
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
		System.out.println("isupdete"+isUpdate);
		return isUpdate;
	}
	
	
	
	/**
	 * ポイント更新用
	 * ゲーム終了時に使うよう
	 * pointの値を獲得した後の値に
	 * sumpointを獲得した値を足した値にしてるよ
	 * ポイントのフィールドは埋めといてね
	 * @param point 
	 * @param getScore 加算ポイント！
	 * @return true:成功 false:失敗
	 */
		public boolean updatePoint(Point point , int getScore) {
			boolean isUpdate = false;

			try {
				this.connect();


				point.setPoint(point.getPoint()+getScore);
				point.setSumPoint(point.getSumPoint()+getScore);
				
				
				String sql = "UPDATE point set point= ? , sum_point "
						+ " where user_id=?";

				PreparedStatement ps = con.prepareStatement(sql);

				

				ps.setInt(1, point.getPoint());
				ps.setInt(2, point.getSumPoint());
				ps.setInt(3, point.getUserId());
				int rowsUpdated = ps.executeUpdate();

				if (rowsUpdated>0) {
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
			System.out.println("isupdete"+isUpdate);
			return isUpdate;
		}

	/**
	 * 総獲得ポイントを更新
	 * pointにuserIdとポイントがある状態でつかってね　
	 * pointにSumPointが更新されるよ
	 * @return true:更新成功　false:更新失敗
	 * @author エセガ　説明更新おれ
	 */
	public boolean updateSum_Point(Point point) {
		boolean isUpdate = false;

		try {
			this.connect();

			String sql = "UPDATE point set sum_point=sum_point+?"
					+ " where user_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			//いまログインしてる人のIDをここに入れたいけどどうやって入れればいいか分からん
			//とりあえず今はpoint表のuserId入れてる
			ps.setInt(1, point.getPoint());
			ps.setInt(2, point.getUserId());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int poi = rs.getInt("point");
				point.setSumPoint(poi);
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
	 * ユーザー登録時のポイントテーブル初期設定
	 * @param user 登録したいユーザー id name hash設定済み 
	 * @return true:登録成功 false:登録失敗
	 * @author ねこ
	 */
	public boolean setUser(User user) {
		try {

			this.connect();
		

			String sql = "INSERT INTO point (user_id , point, sum_point) VALUES (?, '1000', '0')";

			PreparedStatement ps = con.prepareStatement(sql);
	

			ps.setInt(1, user.getUserId());


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
