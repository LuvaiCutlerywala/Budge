package org.luvaicutlerywala.budgetingApp.core.budgetAPI;

import org.luvaicutlerywala.budgetingApp.core.entities.Budget;

import java.util.ArrayList;

public class BudgetRegistry {

    private final ArrayList<Budget> REGISTRY = new ArrayList<>();

    public void addBudget(Budget budget){
        REGISTRY.add(budget);
    }

    public void removeBudget(String title){
        Budget[] budgets = new Budget[REGISTRY.size()];
        REGISTRY.toArray(budgets);
        for(Budget budget: budgets){
            if(budget.getTitle().equals(title)){
                REGISTRY.remove(budget);
            }
        }

    }

    public Budget[] viewBudgets() {
        Budget[] budgets = new Budget[REGISTRY.size()];
        return REGISTRY.toArray(budgets);
    }

}
