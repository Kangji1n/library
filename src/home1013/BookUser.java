package home1013;

import java.util.ArrayList;

public class BookUser {

	
	private String name;
	private String ID;
	private String password;
	private ArrayList<Book> bookrentalList = new ArrayList<>();
	private ArrayList<Book> bookHistory = new ArrayList<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Book> getBookrentalList() {
		return bookrentalList;
	}
	public void setBookrentalList(ArrayList<Book> bookrentalList) {
		this.bookrentalList = bookrentalList;
	}
	public ArrayList<Book> getBookHistory() {
		return bookHistory;
	}
	public void setBookHistory(ArrayList<Book> bookHistory) {
		this.bookHistory = bookHistory;
	}
	public void insertBook(Book book) {
		bookrentalList.add(book);
		bookHistory.add(book);
	}
	public void deleteBook(Book book) {
		bookrentalList.remove(book);
	}
	
	public BookUser(String name, String iD, String password) {
		super();
		this.name = name;
		ID = iD;
		this.password = password;
	}

	
}
