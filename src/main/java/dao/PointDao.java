package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Point;

public class PointDao extends BaseDao {

	/**
	 * 現在ログインしているユーザーの所持ポイントを取得
	 * @return true:取得成功　false:取得失敗
	 * @author エセガ
	 */
	public boolean findPoint(Point point) {
		boolean isPoint = false;
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
	public boolean findSum_Point(Point point) {
		boolean isSumPoint = false;
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
	 * @return true:加算成功　false:加算失敗
	 * @author エセガ
	 */

	public boolean updatePoint(Point point) {
		boolean isUpdate = false;

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
	 * 総獲得ポイントを更新
	 * @return true:更新成功　false:更新失敗
	 * @author エセガ
	 */
	public boolean updateSum_Point(Point point) {
		boolean isUpdate = false;

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
}
