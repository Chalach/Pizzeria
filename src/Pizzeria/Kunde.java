package Pizzeria;

public class Kunde extends Mensch {
    private double geld;

    public Kunde(String name) {
        super(name);
    }

    public double getGeld() {
        return geld;
    }

    public void setGeld(double geld) {
        this.geld = geld;
    }

    @Override
    public String toString() {
        return "Kunde:\n" + super.getName() + "\n" +
                "Geld = " + geld;
    }
}
