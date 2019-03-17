package Databaseøving;

public class OvelsesGruppeController extends DBConn {

	public OvelsesGruppeController()  {
		super("OvelsesGruppe");
	}
	public void regOvelsesGruppe(String type) {
		try {
			this.connect();
			String sqlQuery = "INSERT INTO OvelsesGruppe (Type) VALUES (?)";
			statement = conn.prepareStatement(sqlQuery);
			statement.setString(1,type);
			statement.execute();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
