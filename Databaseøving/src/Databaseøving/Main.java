package Databaseøving;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;

public class Main {

	
	public static void main(String [] args) {
		OvelseController OC = new OvelseController();
		ApparatController AC = new ApparatController();
		TreningsoktController TC = new TreningsoktController();
		OvelsesGruppeController OGC = new OvelsesGruppeController();;
		
		Date date = Date.valueOf("2019-11-1");
		Time time = Time.valueOf("15:00:00");
		TC.regTreningsokt(date, time, 150, 2, 4);
		
	}
}
