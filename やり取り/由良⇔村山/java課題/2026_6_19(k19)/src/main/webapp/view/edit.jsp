<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="pack.User"%>
<%@ page import="pack.BookDAO"%>

<%
BookDAO book = new BookDAO();
book.connect();
User user = book.showUser(Integer.parseInt(request.getParameter("id")));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編集</title>
<link rel='stylesheet' href='css/style.css'>
</head>
<body>
	<h2 class='content'>編集</h2>
	<form action="/sampleProject/UpdateBook?id=<%=user.getId()%>" method='POST'>
		<h3>
			NO:
			<%=user.getId()%></h3>
		投稿者名<br> <input type='text' name='name' value=<%=user.getName()%>><br>
		<br> お気に入り書籍<br> <input type='text' name='favoriteBook'
			value=<%=user.getFavoriteBook()%>><br> <br>
		お気に入りポイント<br>
		<textarea type="text" name='detail' cols="35" rows="2"><%=user.getDetail()%></textarea>
		<br> <input class='btn' type='submit' value='更新'>
	</form>
	<a href="/sampleProject/ReadUsers">戻る</a>
</body>
</html>
