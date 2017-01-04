package Books;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.MySQLImplCmd;

public class RetrieveBook extends MySQLImplCmd {
	 
	ResultSet result;

	@Override
	protected void queryDB() {
		try {
			PreparedStatement store = getConnection().prepareStatement("SELECT * FROM database.book");
			result = store.executeQuery();
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("Values are Retrieved!");
			}
	}
	
	public ResultSet processResult() {
		return result;
	}
	
}