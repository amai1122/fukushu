package 商品マスタ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemsDBAccess {

	protected List<ItemsBean> itemsAccess(String item_id, String item_name, int item_price) throws Exception {

		//データベースの検索
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sqlStr = null;
		List<ItemsBean> list = new ArrayList<ItemsBean>();

		try {
			Class.forName("org.mariadb.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mariadb://localhost/techfun", "root", "");

			//if登録表示なら
				//SQL文字列
				sqlStr ="SELECT * From items WHERE item_id = ' ? '";


			//elseif登録新規登録保存なら
				sqlStr ="LNSERT INTO items(item_id,item_name,item_price)VALUES('"+ item_id +"','"+item_name +"',"+item_price +");";


			//elseif登録編集なら
				sqlStr ="UPDATE items SET item_id='"+ item_id +"',item_name='"+ item_name +"',item_price="+item_price +"WHERE itemid = ? ;";


			//else 削除なら
				sqlStr ="DELETE FROM item_id WHERE itemid =? ;";


			//プリペアードステートメント生成
			pstmt = con.prepareStatement(sqlStr);
			//パラメータ設定
			pstmt.setString(1,item_id);

			//SQL実行
			rs=pstmt.executeQuery();

		}finally {
			if (rs != null) {
				rs.close();
			}
			if(pstmt !=null) {
				pstmt.close();
			}


		}




		return list;

	}

}
