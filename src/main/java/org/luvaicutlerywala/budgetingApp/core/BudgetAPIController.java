package org.luvaicutlerywala.budgetingApp.core;

import org.luvaicutlerywala.budgetingApp.core.entities.Budget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BudgetAPIController {

    @Autowired
    private BudgetRegistry registry;

    @PostMapping("/add-budget")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBudget(@RequestParam String title, @RequestParam double amount){
        registry.addBudget(new Budget(title, amount));
    }

    @GetMapping("/view-budgets")
    public Budget[] viewBudgets(){
        return registry.viewBudgets();
    }

    @DeleteMapping("/remove-budget")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeBudget(@RequestParam String title){
        registry.removeBudget(title);
    }

}
