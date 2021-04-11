package 商品マスタ;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateItems
 */
@WebServlet("/UpdateItems")
public class UpdateItems extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//行先指定
		final String NEXTPAGE_PATH = "/JSP/itemsInsert.jsp";

		request.setCharacterEncoding("UTF-8");

		// 入力データを取得
		int item_no = 0;
		String item_id = null;//dbから取得
		String item_name = null;
		String item_price = null;

		//該当の商品IDの商品ID、商品名、商品単価をDBから持ってくる
		try {
			ItemsDBAccess up = new ItemsDBAccess();
			List<ItemsBean> list = up.itemsDBAccessSelect(item_no, item_id, item_name, item_price);

			//リストから商品ID、商品名、商品単価をリクエストにセット
			for (ItemsBean bn : list) {
				request.setAttribute("item_id", bn.getItem_id());
				request.setAttribute("item_name", bn.getItem_name());
				request.setAttribute("item_price", bn.getItem_price());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// パスをセット
		String path = NEXTPAGE_PATH;

		// itemsInsert.jspに遷移
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
