package com.jirou.zoo.views;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jirou.zoo.models.Comment;

@WebServlet("/comments")
public class CommentsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	System.out.println("Comments!");
    	this.findComments();
        RequestDispatcher dispatch = request.getRequestDispatcher("comments.jsp");
        dispatch.forward(request, response);
    }

    protected List<Comment> findComments() {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
        	String url = "jdbc:mysql://localhost/test_db?characterEncoding=UTF-8&serverTimezone=JST&useSSL=false";
        	String userId = "root";
        	String userPass = "root";
        	Connection con = DriverManager.getConnection(url, userId, userPass);
        	String sql = "SELECT id, name, comment, date FROM comments ORDER BY date ASC";
        	PreparedStatement ps = con.prepareStatement(sql);
        	ResultSet rs = ps.executeQuery();
        	while(rs.next()) {
        		System.out.println(rs.getString("name"));
        	}
        	return new ArrayList<>();
    	} catch (ClassNotFoundException e) {
    		e.printStackTrace();
    		throw new RuntimeException();
    	} catch (SQLException e) {
    		e.printStackTrace();
    		throw new RuntimeException();
		}
    }
}

