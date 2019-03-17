package Databaseøving;

import java.sql.Date;
import java.sql.Time;

public class Treningsokt extends DBConn {

	public Treningsokt() {
		super("Treningsokt");
	}
	
	public void regTreningsokt(Date dato, Time tidspunkt, Time varighet, int personligForm,int prestasjon) {
		try {
			this.connect();
			String sqlQuery = "INSERT INTO Treningsokt (Dato,Tidspunkt,Varighet,PersonligForm,Prestasjon) VALUES (?,?,?,?,?)";
			statement = conn.prepareStatement(sqlQuery);
			statement.setDate(1,dato);
			statement.setTime(2, tidspunkt);
			statement.setTime(3, varighet);
			statement.setInt(4, personligForm);
			statement.setInt(5,prestasjon);
			statement.execute();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
