package fr.triobin.workshopctrl;

import java.util.ArrayList;

public class Workshop {
    private String designation;
    private ArrayList<Workstation> workstations;
    private ArrayList<Product> products;
    private ArrayList<Operator> operators;
    private ArrayList<Goal> goals;

    public Workshop(String designation) {
        this.designation = designation;
        this.workstations = new ArrayList<>();
        this.products = new ArrayList<>();
        this.operators = new ArrayList<>();
        this.goals = new ArrayList<>();
    }

    public void add(Workstation workstation) {
        workstations.add(workstation);
    }

    public void add(Product product) {
        products.add(product);
    }

    public void add(Operator operator) {
        operators.add(operator);
    }

    public void add(Goal goal) {
        goals.add(goal);
    }

    public void print() {
        System.out.println("Workshop: " + designation);
        System.out.println("Workstations: ");
        for (Workstation w : workstations) {
            w.print();
        }
        System.out.println("Products: ");
        for (Product p : products) {
            p.print();
        }
        System.out.println("Operators: ");
        for (Operator o : operators) {
            o.print();
        }
        System.out.println("Goals: ");
        for (Goal g : goals) {
            g.print();
        }
    }
    
    public void replaceToSpecializedGoalsFrom(GeneralGoal generalGoal) {
        ArrayList<SpecializedGoal> specializedGoals = generalGoal.getSpecializedGoals();
        int index = goals.indexOf(generalGoal);
        System.out.println(index);
        goals.remove(generalGoal);
        goals.addAll(index, specializedGoals);
    }

    public SpecializedGoal getNextGoal() {
        if (goals.size() > 0) {
            Goal g = goals.get(0);
            if (g instanceof GeneralGoal) {
                GeneralGoal gg = (GeneralGoal) g;
                replaceToSpecializedGoalsFrom(gg);
                return getNextGoal();
            } else if (g instanceof SpecializedGoal) {
                goals.remove(g);
                return (SpecializedGoal) g;
            }
        }
        return null;
    }
}