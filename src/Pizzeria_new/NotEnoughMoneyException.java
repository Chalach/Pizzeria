package Pizzeria_new;

public class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException() {
        System.err.println("Sie können keine neuen Mitarbeiter einstellen!\nIhnen fehlt das Geld!");
    }
}
