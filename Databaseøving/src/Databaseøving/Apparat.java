package Databaseøving;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class Apparat extends DBConn {
	private PreparedStatement statement;
	private ResultSet rs;
	
	public void addNewApparat(String Navn, String Beskrivelse) {
		
		try {
			this.connect();
			statement.clearParameters();
			String sqlQuery = "INSERT INTO Apparat (Navn,Beskrivelse) VALUES (?,?)";
			statement = conn.prepareStatement(sqlQuery);
			statement.setString(1,Navn);
			statement.setString(2, Beskrivelse);
			
			statement.execute();
		}
		catch (Exception e) {
			System.out.println("FEIL");
		}
	}

	public ArrayList<ArrayList<String>> getApparater() {
	ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
	try {
		int count = 0;
		this.connect();
		String sqlQuery = "SELECT * FROM Apparat";
		statement = conn.prepareStatement(sqlQuery);
		
		this.rs = statement.executeQuery();
		while(rs.next()) {
			ArrayList<String> ob = new ArrayList<String>();
			ob.add(rs.getString("ApparatID"));
			ob.add(rs.getString("Navn"));
			ob.add(rs.getString("Beskrivelse"));
			result.add(ob);
		}
	}
	catch(Exception e) {
		System.out.println(e);
	}
	return result;
		
		
	}
}
	
