package 商品マスタ;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NewItems extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//行先指定
		final String NEXTPAGE_PATH = "/JSP/itemsInsert.jsp";

		//セッションオブジェクト
		HttpSession session =request.getSession();

		request.setCharacterEncoding("UTF-8");

		//if編集の場合、
		if(request.getPrameter("")) {

		//該当の商品IDの商品ID、商品名、商品単価をDBから持ってくる
			try {
				ItemsDBAccess up =new itemsDBAccess();
				List<itemsBean> list =up.searchMemberInfo(name,age);
			} catch (Exception e){
				e.printStackTrace();

			}
		}
		//else
		//新規なので何もしないで登録画面に遷移



		// パスをセット
        String path = NEXTPAGE_PATH;

        // itemsInsert.jspに遷移
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);
	}

}
