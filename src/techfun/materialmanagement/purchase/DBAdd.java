package techfun.materialmanagement.purchase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBAdd {

	public List<DeliveryBean> yomikomiList(String deliListPass) throws IOException{

		Connection conn = null;
		PreparedStatement ps_pians = null;
		ResultSet rset = null;
		String sqlStr = null;



		//リストのインスタンス化
		List<DeliveryBean> deliList = new ArrayList<DeliveryBean>();

		//納品予定テーブルを読み込み
		try {
			// JDBCドライバーのロード
			Class.forName("org.mariadb.jdbc.Driverr");

			//DB接続
			conn = DriverManager.getConnection("jdbc:mariadb://localhost/techfun","root","");

			sqlStr ="SELECT * FROM delivery_plans";

			ps_pians=conn.prepareStatement(sqlStr);


			// SQL文実行//プリペアドステートメントを使ってSQLを実行
			rset =ps_pians.esecuteQuery();

			//SQL実行結果格納
			while(rest.next()) {
				DeliveryBean bean1=new DeliveryBean();

				bean1.setBuyer_cd(rset.getString("buyer_cd"));

			}


		}finally {
			if( sqlStr != null) {
				sqlStr.clone();
			}
		}



	}
}
