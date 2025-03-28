package fr.triobin.workshopctrl;

public class Workstation {
    private String refWorkstation;
    private String dworkstation;
    private Position position;
    private Machine[] machines;

    public Workstation(String refWorkstation, String dworkstation, Position position, Machine[] machines) {
        this.refWorkstation = refWorkstation;
        this.dworkstation = dworkstation;
        this.position = position;
        this.machines = machines;
    }
}
