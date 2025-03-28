package fr.triobin.workshopctrl;

import java.util.ArrayList;

public class Workshop {
    private String designation;
    private ArrayList<Workstation> workstations;
    private ArrayList<Product> products;
    private ArrayList<Operator> operators;
    private ArrayList<Goal> goals;

    private ArrayList<SpecializedGoal> actualGoals;

    public Workshop(String designation) {
        this.designation = designation;
        this.workstations = new ArrayList<>();
        this.products = new ArrayList<>();
        this.operators = new ArrayList<>();
        this.goals = new ArrayList<>();
        this.actualGoals = new ArrayList<>();
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
        System.out.println("- Workshop: " + designation);
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
        return getNextGoal(0);
    }

    public SpecializedGoal getNextGoal(int i) {
        if (goals.size() > i + 1) {
            Goal goal = goals.get(i);
            if (goal instanceof SpecializedGoal) {
                SpecializedGoal specializedGoal = (SpecializedGoal) goal;
                if (specializedGoal.getProduct().getStatus() == NonFinishedProduct.ProductStatus.FREE) {
                    goals.remove(i);
                    specializedGoal.getProduct().setStatus(NonFinishedProduct.ProductStatus.USED);
                    actualGoals.add(specializedGoal);
                    return (SpecializedGoal) goal;
                } else {
                    return getNextGoal(i + 1);
                }
            } else if (goal instanceof GeneralGoal) {
                replaceToSpecializedGoalsFrom((GeneralGoal) goal);
                return getNextGoal(i);
            }
        }
        return null;
    }

    public ArrayList<SpecializedGoal> getActualGoals() {
        return actualGoals;
    }

    public void removeActualGoal(SpecializedGoal goal) {
        actualGoals.remove(goal);
        goal.getProduct().setStatus(NonFinishedProduct.ProductStatus.FREE);
    }
}