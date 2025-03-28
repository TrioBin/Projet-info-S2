package fr.triobin.workshopctrl;

import java.sql.Time;

public class Operation {
    private String name;
    private Machine machine;
    private Time time;

    public Operation(String name, Machine machine, Time time) {
        this.name = name;
        this.machine = machine;
        this.time = time;
    }
    public void afficher() {
        System.out.println("Operation: " + name + " Machine: " + machine + " Time: " + time);
    }
    public void modifier(Machine machine) {
        this.machine = machine;
    }
}
