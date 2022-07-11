package org.luvaicutlerywala.budgetingApp.core.entities;

public class Budget {

    private String title;
    private double amount;

    public Budget(){}

    public Budget(String title, double amount){
        this.title = title;
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString(){
        return String.format("Title: %s\nAmount: %s", this.title, this.amount);
    }

}
