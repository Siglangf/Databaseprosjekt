package Databaseøving;

public class OvelseController extends DBConn {

	public OvelseController() {
		super("Ovelse");
	}
	public void regApperatOvelse(String Navn, String OvelsesGruppe, float AntallKilo, int AntallSett, String Apparat) {
		try {
			this.connect();
			String sqlQuery = "INSERT INTO Ovelse (Navn, OvelsesGruppeID) "
							+ "VALUES ((?),(SELECT OvelsesGruppeID FROM OvelsesGruppe WHERE Type=(?)))";

			statement = conn.prepareStatement(sqlQuery);
			statement.setString(1,Navn);
			statement.setString(2,OvelsesGruppe);
			statement.execute();
			
			sqlQuery = "INSERT INTO ApparatOvelse (OvelseID,ApparatID,AntallKilo,AntallSett) VALUES"
					+  " ((SELECT OvelseID FROM Ovelse WHERE Navn=(?)),"
					+ "(SELECT ApparatID FROM Apparat WHERE Navn=(?)),"
					+ "(?),(?)) ";
			statement = conn.prepareStatement(sqlQuery);
			statement.setString(1, Navn);
			statement.setString(2, Apparat);
			statement.setFloat(3, AntallKilo);
			statement.setInt(4, AntallSett);
			statement.execute();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	

}
