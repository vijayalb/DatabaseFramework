package controller;

import java.sql.ResultSet;

import Books.Book;
import database.DBMgr;

public class GetController {
	
	public void insertBook(Book bookItem) {
		
		DBMgr DBMgrObject = new DBMgr();
		DBMgrObject.insertBook(bookItem);
	}

	public void deleteBook(Book bookItem) {

		DBMgr DBMgrObject = new DBMgr();
		DBMgrObject.deleteBook(bookItem);
	}

	public ResultSet retrieveBook() {
		DBMgr DBMgrObject = new DBMgr();
		return DBMgrObject.retrieveBook();
		
	}

	public void UpdateBook(Book bookItem) {
		DBMgr DBMgrObject = new DBMgr();
		DBMgrObject.updateBook(bookItem);
		
	}

	public void undo() {
		DBMgr DBMgrObject = new DBMgr();
		DBMgrObject.undo();
	}
	
	public void redo() {
		DBMgr DBMgrObject = new DBMgr();
		DBMgrObject.redo();
	}

}
