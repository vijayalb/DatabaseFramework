package Books;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.MySQLImplCmd;

public class InsertBook extends MySQLImplCmd {

	private Book bookItem;
	
	public InsertBook(Book bookItem){
		
		super();
		this.bookItem = bookItem;
	}
	
	@Override
	protected void queryDB() {
		try {
			PreparedStatement commit = getConnection().prepareStatement("COMMIT");
			commit.executeUpdate();
			PreparedStatement store = getConnection().prepareStatement("INSERT INTO database.book(id,title,author,publisher) VALUES(?,?,?,?)");
			store.setInt(1, bookItem.getBookID());
			store.setString(2, bookItem.getBookName());
			store.setString(3, bookItem.getBookAuthor());
			store.setString(4, bookItem.getBookPublisher());
			store.executeUpdate();
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Values are inserted!");
		}
		
	}

	@Override
	protected ResultSet processResult() {
		// TODO Auto-generated method stub
		return null;
	}



}
