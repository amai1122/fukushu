<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品マスタ一覧</title>
</head>
<body>
	<h1>商品マスタ 設計</h1>
	<form action=../servlet/tom.SearchSample " method="post">
		<input type="submit" valus="新規作成" />
			<%
			List<String> errorList = (List<String>) request.getAttribute("errorList");
			if (errorList != null) {
			%>


		<table border="1">
			<tr>
				<th>Ｎｏ．</th>
				<th>商品ＩＤ</th>
				<th>商品名</th>
				<th>商品単価</th>
				<th>削除</th>
			</tr>
			<tr>
				<%
				for (ItemsBean bn : list) {
				%>
				<td><a href="リンク先"> - </a><%=bn.getItem_no()%></td>
				<td><%=bn.getItem_id()%></td>
				<td><%=bn.getItem_name()%></td>
				<td><%=bn.getItem_price()%></td>
				<td><input type="submit" valus="削除" />
				<%
				 }
 				%>
			</tr>


		</table>
	</form>

</body>
</html>