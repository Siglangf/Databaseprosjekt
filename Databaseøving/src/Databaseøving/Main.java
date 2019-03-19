package Databaseøving;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;


public class Main {


	public static void main(String [] args) {
	System.out.println("Hei og velkommen til treningsappen");
	System.out.println("Registrer apparat (1)");
	System.out.println("Registrer øvelse (2)");
	System.out.println("Registrer ny treningsøkt (3)");
	System.out.println("Vis n siste treningsøkter (4)");
	System.out.println("Lag ny øvelsesgruppe (5)");
	System.out.println("Finn øvelser i øvelsesgruppe (6)");
	System.out.println("Finn total treningsmengde i et gitt tidsintervall (7)");
	Scanner sc = new Scanner(System.in);
	String input = sc.nextLine();
	if (input == "1") {
		System.out.println("Skriv inn navn på apparatet:");
		String navn = sc.nextLine();
		System.out.println("Beskriv apparatet: ");
		String beskrivelse = sc.nextLine();

	}

	}
}
