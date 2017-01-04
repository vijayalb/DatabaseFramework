package Books;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.MySQLImplCmd;

public class UpdateBook extends MySQLImplCmd {

	private Book bookItem;
	
	public UpdateBook(Book bookItem) {
		
		super();
		this.bookItem = bookItem;
		
	}

	@Override
	protected void queryDB() {
		
		try {
			
			PreparedStatement store = getConnection().prepareStatement("UPDATE database.book set id = ' " + bookItem.getBookID() + " ', title = ' " + bookItem.getBookName() + " ', author = ' " + bookItem.getBookAuthor() + " ', publisher = ' " + bookItem.getBookPublisher() + " ' WHERE id = ' " + bookItem.getBookID() + " ' ");
			store.executeUpdate();
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Values are updated!");
		}
		
	}

	@Override
	protected ResultSet processResult() {
		// TODO Auto-generated method stub
		return null;
	}

}
