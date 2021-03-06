package Pizzeria_new;

import java.util.ArrayList;

public class Pizza {
    private String name;
    private ArrayList<String> belag = new ArrayList<>();

    public Pizza(String name, ArrayList<String> belag){
        this.name = name;
        this.belag = belag;
    }

    public ArrayList<String> getBelag() {
        return belag;
    }
    
    public void removeBelag(String belag){
        for (int i = 0; i < belag.length(); i++) {
            if(this.belag.get(i).equals(belag)){
                this.belag.remove(i);
            }
        }
    }

    public void addBelag(String belag){
        this.belag.add(belag);
    }

//    public enum Pizzas{
//        GRUNDPIZZA ("Mozzarella", "Origano"),
//        MARGERITHA ("Mozzarella", "Origano");
//
//        Pizzas(String a, String b) {
//        }
//    }
//
//    public static void main(String[] args) {
//        Pizzas pizza = Pizzas.MARGERITHA;
//        Pizzas pizza2 = Pizzas.GRUNDPIZZA;
//        System.out.println(pizza);
//        System.out.println(pizza2);
//    }
}
