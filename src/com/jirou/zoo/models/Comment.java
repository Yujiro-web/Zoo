package com.jirou.zoo.models;

public class Comment {
	public final String name;
	public final String comment;
	public final String date;

	public Comment(String name, String comment, String date) {
		this.name = name;
		this.comment = comment;
		this.date = date;
	}
}
