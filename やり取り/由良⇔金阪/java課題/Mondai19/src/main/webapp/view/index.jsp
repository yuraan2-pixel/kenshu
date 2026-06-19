<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="pack.User"%>
	<!-- %@　～　%まではJavaのコード判定 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー別おすすめ書籍</title>
<link rel='stylesheet' href='css/style.css'>
</head>

<body>
	<h1 class="content">おすすめの書籍を登録してみよう!</h1>
	<h2>登録者一覧</h2>
	<div>
		<table>
			<tr>
				<th>NO</th>
				<th>名前</th>
				<th>詳細</th>
				<th>編集</th>
				<th>削除</th>
			</tr>
			<%
			for (User u : (List<User>) request.getAttribute("bookList")) {
			%>
			<tr>
				<td><%=u.getId()%></td>
				<td><%=u.getName()%></td>
				<td><a href="/sampleProject/ShowBookDetail?id=	<%=u.getId()%>">詳細</a></td>
				<td><a href="/sampleProject/view/edit.jsp?id=	<%=u.getId()%>">編集</a></td>
				<td><a href="/sampleProject/DeleteBook?id=		<%=u.getId()%>">削除</a></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
	<p class="content">新規おすすめ書籍登録</p>
	<form action="/sampleProject/CreateBook" method='POST'>
		<br> 投稿者名<br> 
				<input type='text' name='name' 			placeholder='お名前を入力してください'><br> 
		<br> お気に入り書籍<br>
				<input type='text' name='favoriteBook' 	placeholder='書籍名を入力してください'><br>
		<br> どういった所が気に入ったポイントですか？<br>								<textarea cols="35" rows="2"
						type="text" name='detail'  		placeholder='お気に入りポイントを入力してください'></textarea>
		<br> 	<input 	type='submit' class='btn' 		value='新規登録'>
	</form>
</body>
</html>
