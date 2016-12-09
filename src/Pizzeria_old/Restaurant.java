package Pizzeria_old;

public class Restaurant {
    private String name;
    private Inhaber inhaber;
    private double kapital;

    public Restaurant(String name, Inhaber inhaber) {
        this.name = name;
        this.inhaber = inhaber;
        this.kapital = 7000.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Mensch getInhaber() {
        return inhaber;
    }

    public void setInhaber(Inhaber inhaber) {
        this.inhaber = inhaber;
    }

    public double getKapital() {
        return kapital;
    }

    public void setKapital(double kapital) {
        this.kapital = kapital;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", inhaber=" + inhaber.toString() +
                ", kapital=" + kapital +
                '}';
    }
}
