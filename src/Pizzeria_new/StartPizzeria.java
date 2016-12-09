package Pizzeria_new;

/*
    TODO:
    - GUI
    - User kann sein eigenes Restaurant erstellen
    - Der Inhaber kann Mitarbeiter einstellen und feuern
    - Pizza - Karte muss noch erstellt werden
    - evlt. wird die Übung "PizzabringDienst" noch implementiert
    - Ofen Levelsystem erstellen (mit mehr Kapital kann der Inhaber den Ofen verbessern
      und mehrere Pizzen gleichzeitig zubereiten...)
    - Entscheiden was mit dem Kundenstamm passieren soll
    - Kunde kann zum Mittarbeiter werden?
    - Mitarbeiter kann zum Inhaber werden?
    - Pizzaiolo ist für die Zubereitung in der pizzeria zuständig
    - Finanzen können vom Kelner und vom Inhaber verwaltet werden
    - Simulation von Kunden erstellen, Kunden kommen und gehen (Simulation -> Threads)
*/


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class StartPizzeria {
    private static Pizzeria myRestaurant;
    private static Kundenstamm kundenstamm;
    private boolean isAlreadyReadIn = false;
    private ArrayList<String> namenListe = new ArrayList<>();
    private static ArrayList<Mensch> mitarbeiter = new ArrayList<>();

    private static void createPizzeria() {
        String pizzeriaName;
        String inhaberName;
        String inhaberNachname;
        int inhaberAlter;
        Scanner sc = new Scanner(System.in);

        // Pizzeria
        System.out.println("Willkommen in deiner neuen Pizzeria!");
        System.out.print("Name: ");
        pizzeriaName = sc.nextLine();
        System.out.println("Du bist nun der Inhaber der Pizzeria \"" + pizzeriaName + "\"");

        // Inhaber
        System.out.print("Nenne mir deinen Namen: ");
        inhaberName = sc.nextLine();
        System.out.print("Dein Nachname: ");
        inhaberNachname = sc.nextLine();
        System.out.print("Nur noch dein Alter: ");
        inhaberAlter = sc.nextInt();

        // Der Pizzeria wird der Inhaber zugewiesen
        Inhaber inhaber = new Inhaber(inhaberName, inhaberNachname, inhaberAlter);
        myRestaurant = new Pizzeria(pizzeriaName, inhaber);

        System.out.println("Danke, bevor du aber deine Pizzeria eröffnen kannst müsst du Mitarbeiter einstellen!");
    }

    private static void createKundenstamm()throws IOException{
        kundenstamm = new Kundenstamm();
    }

    private static void mitarbeiterEinstellen() throws IOException {
        /*
            TODO:
             - Namen der Angestellten muss noch random erstellt werden -> OK
             - Bei jedem neu angestellten Mitarbeiter wird ein gewisser Betrag abgezogen -> OK
             - Überprüfung, wenn der Kontostand leer ist. Danach kann kein neuer Mitarbeiter eingestellt werden
        */

        Random randomGenerator = new Random();
        Scanner sc = new Scanner(System.in);
        ArrayList<String> namenListe = kundenstamm.getNamenListe();
        int input;

        System.out.println("Welchen Mitarbeiter möchten sie einstellen?");

        System.out.println("Stelle nun deine Mitarbeiter ein: ");
        System.out.println("Zur Auswahl stehen:");
        System.out.println("1) Kellner/in");
        System.out.println("2) Pizzaiolo");

        do {
            input = sc.nextInt();
            if (input == 1 && kostenMitarbeiter(-200)) {
                Kellner kellner = new Kellner(namenListe.get(randomGenerator.nextInt(70)));
                mitarbeiter.add(kellner);
                System.out.println("Kellner eingestellt");
            } else if (input == 2 && kostenMitarbeiter(-300)) {
                Pizzaiolo pizzaiolo = new Pizzaiolo(namenListe.get(randomGenerator.nextInt(70)));
                mitarbeiter.add(pizzaiolo);
                System.out.println("Pizzaiolo eingestellt");
            } else {
                System.out.println("Falsche Eingabe");
            }
            System.out.println(myRestaurant.getKapital());
            System.out.println(mitarbeiter);
        } while (input != 0);
    }

    private static boolean kostenMitarbeiter(double kapital) {
        if(myRestaurant.getKapital() + kapital < 0){
            System.err.println("Sie können keine neuen Mitarbeiter einstellen!\nIhnen fehlt das Geld!");
            return false;
        }
        else{
            myRestaurant.addKapital(kapital);
        }
        return true;
    }

    private ArrayList<String> getNamenListe() throws IOException{
        if(!isAlreadyReadIn){
            try (BufferedReader br = new BufferedReader(new FileReader("namen\\namen.txt"))) {
                for (String c; (c = br.readLine()) != null; ) {
                    namenListe.add(c);
                }
            } catch (FileNotFoundException e) {
                System.err.println("Konnte die Datei nicht finden!");
            }
            isAlreadyReadIn = true;
        }
        return namenListe;
    }

    private static void startSimulation(){
        System.out.println("Perfekt, du kannst nun deine Pizzeria eröffnen!");
        System.out.println("Simulation startet nun");
    }

    public static void main(String[] args) throws Exception {
        /*
            TODO
            Ablauf:
                - pizzeria kann vom Inhaber erstellt werden -> OK
                - Zu Karrierebeginn muss er Mitarbeiter einstellen -> OK
                - Danach entschließt er sich die pizzeria zu öffnen:
                    - evtl. Auswahl, welche Pizzen er verkaufen möchte?
                - Simulation beginnt:
                    - Kunden kommen und gehen nun zur pizzeria
                        - werden vom Kellner/in bediehnt
                        - Bargeld wird vom Kellner/in und Inhaber verwaltet
                    - Inhaber kann neue Mitarbeiter einstellen
                    - Inhaber kann Mitarbeiter feuern
                    - Inhaber kann die Gerätschaften (Ofen) upgraden lassen
        */
        createPizzeria();
        createKundenstamm();
        mitarbeiterEinstellen();
        startSimulation();
    }
}