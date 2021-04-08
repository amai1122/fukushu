package techfun.materialmanagement.purchase;

import java.io.IOException;

public class GetSupplierName {

	public static void main(String[] args) {

		System.out.println("プログラム「GetSupplierName」の処理を開始します");
		try {
			//delivery_plansテーブルを読み込んでJAVABEANとリストに格納する
			DBAdd kakunou=new DBAdd();
			List<DeliveryBean>delList =kakunou.yomikomiList(deliListPass);

			//order_infoテーブルを読み込んでMapに格納する

			//仕入れ先コードで検索して仕入先名称を入れる

			//new_delivery_plansテーブルにJAVABEANとリストの内容を書き込む

		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			System,out.println("プログラム「GetSupplierName」の処理を終了します")
		}

	}

}
