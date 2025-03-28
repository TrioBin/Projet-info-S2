package fr.triobin.workshopctrl;

public class RefMachine {
    private String code;

    public RefMachine(String code) {
        this.code = code;
    }

    public void print() {
        System.out.println("RefMachine: " + code);
    }
}
