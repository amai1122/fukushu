package techfun.materialmanagement.purchase;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import firstJDBC.MemberBean;

public class DBAccess {

	public void delivery_plansAccess(List<JdbcMondaiBean> list) throws ClassNotFoundException, SQLException {
	// DB接続、SQL発行に必要となるインターフェースの宣言
	Connection conn = null;
	PreparedStatement pstmt = null;
	String inPproductId = null;
	String inProductName = null;

	ResultSet rset = null;

	int inCategoryId = 0;
	int inPrice = 0;

	String sqlStr = null;
	try {
		// JDBCドライバーのロード
		Class.forName("org.mariadb.jdbc.Driver");

		// MariaDB接続
		conn = DriverManager.getConnection("jdbc:mariadb://localhost/techfun", "root", "");

		// 自動コミットをオフに設定
		conn.setAutoCommit(false);

		// SQL文の文字列
		sqlStr = "SELECT * FROM delivery_plans";

		// プリペアドステートメント生成
		pstmt = conn.prepareStatement(sqlStr);

		// SQL文実行
		rset = pstmt.executeQuery();

		//DBからListに保存

		//リストのインスタンス化
		List<MemberBean> sqlRist = new ArrayList<MemberBean>();


		while(rset.next()) {//実行結果の読込

			DeliveryBean bean1 = new DeliveryBean();//beanのインスタンス化

			bean1.setBuyer_cd(rset.getString("buyer_cd"));
			bean1.setBuyer_cd(rset.getString("component_cd"));
			bean1.setBuyer_cd(rset.getString("supplier_cd"));
			bean1.setBuyer_cd(rset.getString("supplier_nm"));
			bean1.setBuyer_cd(rset.getString("order_qty"));

			//baenをリストにSET
			sqlRist.add(bean1);
		}

			// リストから値をセット
			inPproductId = mondaiBean.getProductId();
			inProductName = mondaiBean.getProductName();
			inCategoryId = mondaiBean.getCategoryId();
			inPrice = mondaiBean.getPrice();

			// INSERT文の文字列
			sqlStr = "INSERT INTO product("
					+ "product_id,product_name,category_id,price"
					+ ") VALUES ('"
					+ inPproductId + "','" + inProductName + "','"
					+ inCategoryId + "','" + inPrice + "');";

			// プリペアドステートメント生成
			pstmt = conn.prepareStatement(sqlStr);

			// INSERT文実行
			pstmt.executeUpdate();

			// プリペアドステートメントをクローズ
			pstmt.close();

			//				System.out.println(inPproductId + "\t" + inProductName + "\t"
			//						+ inCategoryId + "\t" + inPrice);
		}
		//処理を確定
		conn.commit();

	}catch(

	SQLException e)
	{

		try {
			if (conn != null) {
				//ロールバック処理
				conn.rollback();
			}
		} catch (SQLException ex) {
			throw ex;
		}

		throw e;
	}finally
	{
		if (pstmt != null) {
			// クローズ処理
			pstmt.close();
		}
		if (conn != null) {
			// 接続をクローズ
			conn.close();

		}
	}

}
