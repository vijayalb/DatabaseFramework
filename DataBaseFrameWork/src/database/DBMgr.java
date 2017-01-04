package database;

import java.sql.ResultSet;

import Books.Book;

public class DBMgr {
	
	public void insertBook(Book bookItem) {
		
		DBImplInterface imp = new MySQLImpl();
		imp.insertBook(bookItem);
		
	}

	public void deleteBook(Book bookItem) {
		
		DBImplInterface imp = new MySQLImpl();
		imp.deleteBook(bookItem);
		
	}

	public ResultSet retrieveBook() {

		DBImplInterface imp = new MySQLImpl();
		ResultSet result = imp.retrieveBook();
		return result;
		
	}

	public void updateBook(Book bookItem) {
		
		DBImplInterface imp = new MySQLImpl();
		imp.updateBook(bookItem);
		
	}

	public void undo() {
		DBImplInterface imp = new MySQLImpl();
		imp.undo();
		
	}
	
	public void redo() {
		DBImplInterface imp = new MySQLImpl();
		imp.redo();
		
	}

}
