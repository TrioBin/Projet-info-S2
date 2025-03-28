package fr.triobin.workshopctrl;

public class Operator {
    private String code;
    private String name;
    private String surname;
    private RefMachine skills;
    private OperatorStatus status;

    public Operator(String code, String name, String surname, RefMachine skills, OperatorStatus status) {
        this.code = code;
        this.name = name;
        this.surname = surname;
        this.skills = skills;
        this.status = status;
    }

    public enum OperatorStatus {
        AVAILABLE, BUSY, BREAK
    }
}
