package database;

import java.sql.ResultSet;

import Books.Book;

public interface DBImplInterface {

	void insertBook(Book bookItem);

	void deleteBook(Book bookItem);

	ResultSet retrieveBook();

	void updateBook(Book bookItem);

	void undo();
	
	void redo();

}
