package Databaseøving;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class ApparatController extends DBConn {
	
	public ApparatController() {
		super("Apparat");
		
	}

	public void regApparat(String Navn, String Beskrivelse) {
		try {
			this.connect();
			String sqlQuery = "INSERT INTO Apparat (Navn,Beskrivelse) VALUES (?,?)";
			statement = conn.prepareStatement(sqlQuery);
			statement.setString(1,Navn);
			statement.setString(2, Beskrivelse);
			statement.execute();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}