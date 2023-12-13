package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Point;

public class PointDao extends BaseDao {

	/**
	 * 現在ログインしているユーザーの所持ポイントを確認
	 * @return ユーザーの所持ポイント
	 * @author エセガ
	 */
	public int findPoint(Point point) {
		try {

			this.connect();

			String sql = "SELECT user_id, point"
					+ "FROM point"
					+ "WHERE user_id = ? ";

			PreparedStatement ps = con.prepareStatement(sql);

			//いまログインしてる人のIDをここに入れたいけどどうやって入れればいいか分からん
			//とりあえず今はpoint表のuserId入れてる
			ps.setInt(1, point.getUserId());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int poi = rs.getInt("point");
				point.setPoint(poi);
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

	/**
	 * 
	 *現在ログインしているユーザーの総獲得ポイントを確認
	 * @return ユーザーの総獲得ポイント
	 * @author エセガ
	 */
	public int findSum_Point(Point point) {
		try {

			this.connect();

			String sql = "SELECT user_id, sum_point"
					+ "FROM point"
					+ "WHERE user_id = ? ";

			PreparedStatement ps = con.prepareStatement(sql);

			//いまログインしてる人のIDをここに入れたいけどどうやって入れればいいか分からん
			//とりあえず今はpoint表のuserId入れてる
			ps.setInt(1, point.getUserId());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int sum = rs.getInt("sum_point");
				point.setSumPoint(sum);
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
		return point.getSumPoint();
	}

	/**
	 * ゲームで獲得したポイントを所持ポイントに加算
	 * 
	 * @return 獲得ポイントを加算したユーザーの所持ポイント
	 * @author エセガ
	 */

	public int setPoint(Point point) {

		//ゲームで獲得したポイントを入れる変数(後々修正する)(とりあえずの仮置き)
		int TMP = 0;
		try {
			this.connect();

			String sql = "UPDATE point set point=point+" + TMP
					+ " where user_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			//いまログインしてる人のIDをここに入れたいけどどうやって入れればいいか分からん
			//とりあえず今はpoint表のuserId入れてる
			ps.setInt(1, point.getUserId());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int poi = rs.getInt("point");
				point.setPoint(poi);
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

	/**
	 * 総獲得ポイントを更新
	 * @return 獲得ポイントを加算したユーザーの総獲得ポイント
	 * @author エセガ
	 */
	public int setSum_Point(Point point) {

		//ゲームで獲得したポイントを入れる変数(後々修正する)(とりあえずの仮置き)
		int TMP = 0;
		try {
			this.connect();

			String sql = "UPDATE point set sum_point=sum_point+" + TMP
					+ " where user_id=?";

			PreparedStatement ps = con.prepareStatement(sql);

			//いまログインしてる人のIDをここに入れたいけどどうやって入れればいいか分からん
			//とりあえず今はpoint表のuserId入れてる
			ps.setInt(1, point.getUserId());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int poi = rs.getInt("point");
				point.setSumPoint(poi);
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
		return point.getSumPoint();
	}
}
