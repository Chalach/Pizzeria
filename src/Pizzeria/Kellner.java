package Pizzeria;

public class Kellner extends Mensch{
    private String pizza;

    public Kellner(String name) {
        super(name);
    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
