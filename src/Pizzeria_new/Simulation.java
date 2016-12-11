package Pizzeria_new;

import java.util.ArrayList;
import java.util.Random;

public class Simulation extends Thread {
    private static int threadCount = 0;
    private static ArrayList<Kunde> kundeArrayList = new ArrayList<>();

    private void printErgebnis(){
        if(threadCount == 5){
            for(Kunde i : kundeArrayList){
                System.out.println(i);
            }
        }
    }

    public void run() {
        Random random = new Random();
        Kunde kunde = new Kunde("");
        int duration = random.nextInt(10000);
        System.out.println(duration);
        try {
            Thread.sleep(duration);
            kundeArrayList.add(kunde);
            int threadCount1 = threadCount++;
            System.out.println("Thread: " + threadCount1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printErgebnis();
    }

    public static void main(String args[]) throws InterruptedException {
        System.out.println("Ich starte nun einen Thread");
        (new Simulation()).start();
        (new Simulation()).start();
        (new Simulation()).start();
        (new Simulation()).start();
        (new Simulation()).start();
    }

}