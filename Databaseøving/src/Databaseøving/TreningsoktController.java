package Databaseøving;


import java.sql.Date;
import java.sql.Time;
import java.util.*;


public class TreningsoktController extends DBConn {
	public TreningsoktController() {
		super("Treningsokt");
	}
	
	public void regTreningsokt(String dato, String tidspunkt, float varighet, int personligForm,int prestasjon, String notat) {
		try {
			
			this.connect();
			String sqlQuery = "INSERT INTO Treningsokt (Dato,Tidspunkt,Varighet,PersonligForm,Prestasjon) VALUES (?,?,?,?,?)";
			statement = conn.prepareStatement(sqlQuery);
			statement.setString(1,dato);
			statement.setString(2, tidspunkt);
			statement.setFloat(3, varighet);
			statement.setInt(4, personligForm);
			statement.setInt(5,prestasjon);
			statement.execute();
			int oktID = this.getID("Dato", dato);
			sqlQuery = "INSERT INTO Notat (Tekst,TreningsoktID) VALUES (?,?)";
			statement = conn.prepareStatement(sqlQuery);
			statement.setString(1, notat);
			statement.setInt(2, oktID);
			statement.execute();
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	public ArrayList<ArrayList<String>> getNLatest(int n) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		try {
			this.connect();
			String sqlQuery = "SELECT * FROM " +navn +" ORDER BY Dato DESC ";
			statement = conn.prepareStatement(sqlQuery);
			this.rs = statement.executeQuery();
			int colLength = rs.getMetaData().getColumnCount();
			int count = 0;
			while(rs.next()&&count<n) {
				ArrayList<String> ob = new ArrayList<String>();
				for(int i = 1; i<=colLength;++i) {
					ob.add(rs.getString(i));
				}
				result.add(ob);
				count++;
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
}
