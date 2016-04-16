package kr.o3selab.library.conf;

import java.math.BigInteger;

public class Book {
	private int id;
	private String name;
	private int type;
	private String author;
	private String publisher;
	private int date;
	private BigInteger isbn;
	private int price;
	private String commit;
	private boolean status;
	
	public Book(int id, String name, int type, String author, String publisher, int date, BigInteger isbn, int price, String commit) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.author = author;
		this.publisher = publisher;
		this.date = date;
		this.isbn = isbn;
		this.price = price;
		this.commit = commit;
		this.status = false;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public BigInteger getIsbn() {
		return isbn;
	}
	public void setIsbn(BigInteger isbn) {
		this.isbn = isbn;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCommit() {
		return commit;
	}
	public void setCommit(String commit) {
		this.commit = commit;
	}
	
}
