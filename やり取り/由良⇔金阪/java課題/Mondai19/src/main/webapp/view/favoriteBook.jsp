<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
	
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="pack.User"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' href='css/style.css'>
</head>

<body>
	<h2>お気に入り詳細</h2>
	<%
	for (User u : (List<User>) request.getAttribute("bookList")) {
	%>
	<p class="content">No:		  </p><%=u.getId()%>
	<p class='content'>登録者:	</p><%=u.getName()%>
	<hr>
	<p class='content'>	おすすめ書籍: </p><%=u.getFavoriteBook()%>
	<p class='content'>	お気に入りポイント	</p><%=u.getDetail()%>
	<%
	}
	%>
	<p>
		<a href="/sampleProject/ReadUsers">戻る</a>
	</p>

</body>
</html>
