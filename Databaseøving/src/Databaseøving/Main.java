package Databaseøving;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;


public class Main {
	public static void printList(ArrayList<ArrayList<String>> li){
		for(int i = 0; i<li.size(); i++) {
			System.out.println(li.get(i));
		}
	}
	public static void treningsoktN(Scanner sc) {
		System.out.println("Hvor mange økter vil du se?");
		int antall = sc.nextInt();
		TreningsoktController tc = new TreningsoktController();
		ArrayList<ArrayList<String>> list = tc.getNLatest(antall);
		printList(list);
	}
	public static void treningsokt (Scanner sc) {
		System.out.println("Dato yyyy-mm-dd: ");
		String dato = sc.next();
		TreningsoktController tc = new TreningsoktController();
		System.out.println("Tidspunkt: xx:xx:xx ");
		String tidspunkt = sc.next();
		System.out.println("Varighet i minutter: ");
		int varighet = sc.nextInt();
		System.out.println("Personlig form (1-10): ");
		int personligform = sc.nextInt();
		System.out.println("Prestasjon (1-10): ");
		int prestasjon = sc.nextInt();
		System.out.println("Skriv et notat til økten: ");
		String notat = sc.nextLine();
		tc.regTreningsokt(dato, tidspunkt, varighet, personligform, prestasjon, notat);
	}
	public static void treningsgruppe(Scanner sc) {
		System.out.println("Hvilken type øvelsesgruppe vil du registrere?");
		String beskrivelse = sc.next();
		OvelsesGruppeController ogc = new OvelsesGruppeController();
		ogc.regOvelsesGruppe(beskrivelse);
	}
	public static void apparat(Scanner sc) {
		ApparatController AC = new ApparatController();
		System.out.println("Skriv inn navn på apparatet:");
		String navn = sc.next();
		System.out.println("Beskriv apparatet: ");
		String beskrivelse = sc.next();
		AC.regApparat(navn, beskrivelse);
	}
	public static void finnOvelse(Scanner sc) {
		System.out.println("Hvilken øvelsesgruppe vil du hente øvelser fra (tall)?");
		OvelsesGruppeController OGC = new OvelsesGruppeController();
		ArrayList<ArrayList<String>> grupper = OGC.getAll();
		printList(grupper);
		int gruppe = sc.nextInt();
		ArrayList<ArrayList<String>> ovelser = OGC.getOvelser(gruppe);
		printList(ovelser);
		
	}
	public static void ovelse(Scanner sc) {
		System.out.println("Skriv inn navnet på øvelsen");
		String navn = sc.next();
		System.out.println("Hvilken øvelsesgruppe vil du legge den til i? (navn), skriv 'n' for å lage ny");
		OvelsesGruppeController OGC = new OvelsesGruppeController();
		ArrayList<ArrayList<String>> list = OGC.getAll();
		printList(list);
		String gruppe = sc.next();
		if(gruppe.equals("n")) {
			treningsgruppe(sc);
			list = OGC.getAll();
			printList(list);
		}
		
		System.out.println("Er øvelsen på et apparat?(y/n)");
		String a = sc.next();
		if(a.equals("y")) {
			
			System.out.println("Hvilket apparat vil du bruke (tall), skriv 'n' for å lage nytt");
			ApparatController AC = new ApparatController();
			list = AC.getAll();
			printList(list);
			String app = sc.next();
			if(app.equals("n")) {
				apparat(sc);
				list = AC.getAll();
				printList(list);
			}
			System.out.println("Skriv inn antall kilo");
			float kilo = sc.nextFloat();
			System.out.println("Antall sett");
			int sett = sc.nextInt();
			OvelseController OC = new OvelseController();
			OC.regApperatOvelse(navn, gruppe, kilo, sett, app);
			
		}
		else {
			
		}
		
	}
	public static void treningsmengde(Scanner sc) {
		TreningsoktController tc = new TreningsoktController();
		ArrayList<ArrayList<String>> list = tc.getNLatest(7);
		float varighet = 0;
		for(int i = 0; i < list.size(); i++) {
			varighet+=Float.parseFloat(list.get(i).get(3));
		}
		System.out.println(varighet + " minutter");
	}
	public static void main(String [] args) {

		System.out.println("Hei og velkommen til treningsappen");
		boolean running = true;
	
		while (running) {
			System.out.println("Registrer apparat (1)");
			System.out.println("Registrer øvelse (2)");
			System.out.println("Registrer ny treningsøkt (3)");
			System.out.println("Vis n siste treningsøkter (4)");
			System.out.println("Lag ny øvelsesgruppe (5)");
			System.out.println("Finn øvelser i øvelsesgruppe (6)");
			System.out.println("Finn total treningsmengde siste 7 dagene (7)");
			System.out.println("Avslutt(8)");
			Scanner sc = new Scanner(System.in);
			Integer input = sc.nextInt();
			
			switch(input) {
			case 1:
				apparat(sc);
				break;
			case 2:
				ovelse(sc);
				break;
			case 3:
				treningsokt(sc);
				break;
				
			case 4:
				treningsoktN(sc);
				break;
			case 5: 
				treningsgruppe(sc);
				break;
			case 6:
				finnOvelse(sc);
				break;
			case 7:
				treningsmengde(sc);
				break;
			case 8:
				System.out.println("Bye");
				running = false;
			}
			

		}	
	}
}
