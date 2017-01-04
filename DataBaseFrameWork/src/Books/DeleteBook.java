package Books;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.MySQLImplCmd;

public class DeleteBook extends MySQLImplCmd {

	private Book bookItem;
	
	public DeleteBook(Book bookItem) {
		
		super();
		this.bookItem = bookItem;
		
	}
	
	protected void queryDB() {
		try {
			PreparedStatement store = getConnection().prepareStatement("DELETE FROM database.book WHERE id = ' " + bookItem.getBookID() + " ' ");
			store.executeUpdate();
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Values are deleted!");
		}
		
	}

	@Override
	protected ResultSet processResult() {
		// TODO Auto-generated method stub
		return null;
	}

}
