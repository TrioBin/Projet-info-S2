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

    public void print() {
        System.out.println("Workstation: " + dworkstation);
        position.print();
        System.out.println("Machines: ");
        for (Machine m : machines) {
            m.print();
        }
    }

    public void modify(Position position) {
        this.position = position;
    }

    public void modify(Machine[] machines) {
        this.machines = machines;
    }

    public void addMachine(Machine m) {
        Machine[] newMachines = new Machine[machines.length + 1];
        for (int i = 0; i < machines.length; i++) {
            newMachines[i] = machines[i];
        }
        newMachines[machines.length] = m;
        machines = newMachines;
    }

    public void removeMachine(Machine m) {
        Machine[] newMachines = new Machine[machines.length - 1];
        int j = 0;
        for (int i = 0; i < machines.length; i++) {
            if (machines[i] != m) {
                newMachines[j] = machines[i];
                j++;
            }
        }
        machines = newMachines;
    }

    public void changeMachine(Machine m, Machine newM) {
        for (int i = 0; i < machines.length; i++) {
            if (machines[i] == m) {
                machines[i] = newM;
            }
        }
    }
}
