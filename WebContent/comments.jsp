<%@page import="com.jirou.zoo.models.Comment"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Comment> comments = (List<Comment>) request.getAttribute("comments");
%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>コメント</title>
</head>

<body>
  <div class="container">
    <%	for (int i = 0; i < comments.size(); i++) {	%>
      <div>
        <div><%= comments.get(i).name %></div>
        <div><%= comments.get(i).comment %></div>
      </div>
      <hr>
    <% } %>
    <form>
      <div>
        <div>
          <label for="">名前</label>
        </div>
        <div>
          <input type="text">
        </div>
      </div>
      <div>
        <div>
          <label for="">コメント</label>
        </div>
        <div>
          <textarea name="" cols="30" rows="10"></textarea>
        </div>
      </div>
      <div>
        <input type="submit" value="投稿">
      </div>
    </form>
  </div>
</body>

</html>