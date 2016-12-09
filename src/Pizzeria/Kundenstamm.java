package Pizzeria;

import java.util.ArrayList;

public class Kundenstamm {
    private ArrayList<Kunde> stammKunden = new ArrayList<>();

    public Kundenstamm() {
    }

    public void addKunde(Kunde kunde){
        stammKunden.add(kunde);
    }

    @Override
    public String toString() {
        return "Kundenstamm:\n" + stammKunden;
    }
}
