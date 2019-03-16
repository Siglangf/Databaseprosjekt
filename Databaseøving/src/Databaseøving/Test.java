package Databaseøving;
import java.sql.*;
import java.util.*;
public class Test extends DBConn {
	
	private PreparedStatement testStatement;
	public Test() {
		super();
	}
	public void sporr () {
		try {
			testStatement = conn.prepareStatement("SELECT * FROM Treningsokt");
			ResultSet rs = testStatement.executeQuery();
			System.out.println(rs.getRow());
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public static void main(String [] args) {
		Test test = new Test();
		test.connect();
		test.sporr();
	}
}