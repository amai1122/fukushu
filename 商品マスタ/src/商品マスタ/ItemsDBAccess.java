package 商品マスタ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemsDBAccess {

	protected List<ItemsBean> itemsDBAccessSelect(int item_no, String item_id, String item_name, String item_price)
			throws Exception {

		//データベースの検索
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sqlStr = null;
		List<ItemsBean> list = new ArrayList<ItemsBean>();

		try {
			//ドライバダウンロード
			Class.forName("org.mariadb.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mariadb://localhost/techfun", "foot", "");

			//SQL文字列
			sqlStr = "SELECT * From items WHERE item_id = '" + item_no + "';";

			// プリペアドステートメント生成
			pstmt = con.prepareStatement(sqlStr);

			// SQL文実行
			rs = pstmt.executeQuery();

			//戻り値のlistにセット
			while (rs.next()) {
				ItemsBean bn = new ItemsBean();
				bn.setItem_no(rs.getInt(0));
				bn.setItem_id(rs.getString(1));
				bn.setItem_name(rs.getString(2));
				bn.setItem_price(rs.getInt(3));

				list.add(bn);
			}

		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return list;
	}

	//------------------------------------------------

	protected void itemsDBAccessInsert(String item_id, String item_name, String item_price) throws Exception {

		//データベースの検索
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sqlStr = null;

		try {
			//ドライバダウンロード
			Class.forName("org.mariadb.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mariadb://localhost/techfun", "root", "");

			//登録新規登録保存

			Integer item_price_int = Integer.valueOf(item_price);
			//SQL文字列
			sqlStr = "INSERT INTO items(item_id,item_name,item_price)VALUES('" + item_id + "','" + item_name + "',"
					+ item_price_int + ");";

			//プリペアードステートメント生成
			pstmt = con.prepareStatement(sqlStr);

			//SQL実行
			pstmt.executeUpdate();

		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}

	//------------------------------------------------

	protected void itemsDBAccessUpdate(String item_id, String item_name, String item_price) throws Exception {

		//データベースの検索
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sqlStr = null;

		try {
			//ドライバダウンロード
			Class.forName("org.mariadb.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mariadb://localhost/techfun", "root", "");

			//登録編集
			sqlStr = "UPDATE items SET item_id='" + item_id + "',item_name='" + item_name + "',item_price=" + item_price
					+ "WHERE itemid ='" + Integer.valueOf(item_price) + "';";

			//プリペアードステートメント生成
			pstmt = con.prepareStatement(sqlStr);

			//SQL実行
			pstmt.executeUpdate();

		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}

	//------------------------------------------------

	protected void itemsDBAccessDelete(String item_id) throws Exception {

		//データベースの検索
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sqlStr = null;

		try {
			//ドライバダウンロード
			Class.forName("org.mariadb.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mariadb://localhost/techfun", "root", "");

			//削除
			sqlStr = "DELETE FROM item_id WHERE itemid ='" + item_id + "';";

			//プリペアードステートメント生成
			pstmt = con.prepareStatement(sqlStr);

			//SQL実行
			pstmt.executeUpdate();

		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}

}
