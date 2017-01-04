package database;

import java.sql.ResultSet;

import Books.Book;
import Books.DeleteBook;
import Books.InsertBook;
import Books.RetrieveBook;
import Books.UpdateBook;

public class MySQLImpl implements DBImplInterface {

	@Override
	public void insertBook(Book bookItem) {
		
		InsertBook cmd = new InsertBook(bookItem);
		cmd.execute();
		
	}

	@Override
	public void deleteBook(Book bookItem) {
		
		DeleteBook cmd = new DeleteBook(bookItem);
		cmd.execute();
		
	}

	@Override
	public ResultSet retrieveBook() {
		RetrieveBook cmd = new RetrieveBook();
		cmd.execute();
		return cmd.processResult();
	}

	@Override
	public void updateBook(Book bookItem) {
		UpdateBook cmd = new UpdateBook(bookItem);
		cmd.execute();
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}

}
