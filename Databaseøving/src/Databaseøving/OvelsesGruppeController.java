package Databaseøving;
import java.sql.ResultSet;
import java.util.*;

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
	public ArrayList<ArrayList<String>> getOvelser(int id){
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		try {
			this.connect();
			String sqlQuery = "SELECT (navn) from Ovelse WHERE OvelsesGruppeID=(?)";
			statement = conn.prepareStatement(sqlQuery);
			statement.setInt(1,id);
			ResultSet rs = statement.executeQuery();
			int colLength = rs.getMetaData().getColumnCount();
    		while(rs.next()) {
    			ArrayList<String> ob = new ArrayList<String>();
    			for(int i = 1; i <= colLength; ++i) {
    				ob.add(rs.getString(i));
    			}
    			result.add(ob);
    		}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
}
