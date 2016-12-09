package Pizzeria_old;

import java.util.Scanner;

public class Pizzeria {
    public static void main(String[] args) {
        Mensch alex = new Kellner("Alex");
        System.out.println(alex);
        alex = new Pizzaiolo("Alex");
        System.out.println(alex);
        System.out.println(alex.getClass().getName());
        System.out.println("Hallo, Willkommen bei deiner Pizzeria_old");

        Scanner sc = new Scanner(System.in);
        System.out.println("Geben Sie Ihren Namen der Pizzeria_old ein.");
        String name = sc.nextLine();
        System.out.println("Geben Sie Ihren Namen ein.");
        String name1 = sc.nextLine();

        Restaurant myRestaurante = new Restaurant(name, new Inhaber(name1));

        System.out.println(myRestaurante);
        Kunde kunde = new Kunde("Alex");
        Kundenstamm stammKunden = new Kundenstamm();

        stammKunden.addKunde(kunde);

        System.out.println(kunde);
        System.out.println(stammKunden);
    }
}
