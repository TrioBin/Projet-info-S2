package fr.triobin.workshopctrl;

import java.util.ArrayList;

public class Operator {
    private String code;
    private String name;
    private String surname;
    private ArrayList<RefMachine> skills;
    private OperatorStatus status;

    public Operator(String code, String name, String surname, ArrayList<RefMachine> skills, OperatorStatus status) {
        this.code = code;
        this.name = name;
        this.surname = surname;
        this.skills = skills;
        this.status = status;
    }

    public enum OperatorStatus {
        AVAILABLE, BUSY, BREAK
    }

    public void print() {
        System.out.println("- Operator: " + code);
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Skills:");
        for (RefMachine skill : skills) {
            System.out.println(skill);
        }
        System.out.println("Status: " + status);
    }

    public void modify(ArrayList<RefMachine> skills) {
        this.skills = skills;
    }

    public void modify(OperatorStatus status) {
        this.status = status;
    }
    public void remove(){
        this.status = OperatorStatus.BREAK;
    }
}
