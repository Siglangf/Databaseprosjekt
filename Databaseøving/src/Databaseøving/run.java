package Databaseøving;
import java.util.ArrayList;

public class run {
	public static void main(String [] args) {
		Apparat app = new Apparat();
		ArrayList<ArrayList<String>> apparater = app.getApparater();
		for(int i = 0; i<apparater.size(); i++) {
			System.out.println(apparater.get(i));
		}
	}
}
