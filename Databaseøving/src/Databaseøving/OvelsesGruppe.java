package Databaseøving;

public class OvelsesGruppe extends DBConn {

	public OvelsesGruppe()  {
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
