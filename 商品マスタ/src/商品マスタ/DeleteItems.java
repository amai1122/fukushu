package 商品マスタ;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteItems extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//削除は元の画面に戻る
		final String NEXTPAGE_PATH = "/JSP/itemsInsert.jsp";

		request.setCharacterEncoding("UTF-8");

		//該当の商品IDの商品ID、商品名、商品単価をDBから消す
		try {
			ItemsDBAccess up = new ItemsDBAccess();

			String item_id = request.getParameter("item_id");

			up.itemsDBAccessDelete(item_id);

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
