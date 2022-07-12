package org.luvaicutlerywala.budgetingApp.core;

import org.luvaicutlerywala.budgetingApp.core.entities.Budget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api")

public class BudgetAPIController {

    @Autowired
    private BudgetRegistry registry;
    private static final Logger LOGGER = Logger.getLogger("org.luvaicutlerywala.budgetingApp.core.BudgetAPIController");

    @PostMapping("/add-budget")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBudget(@RequestParam String title, @RequestParam double amount){
        Budget budget = new Budget(title, amount);
        registry.addBudget(budget);
        LOGGER.info("Budget added to registry: " + budget);
    }

    @GetMapping("/view-budgets")
    public Budget[] viewBudgets(){
        LOGGER.info("Budget registry accessed");
        return registry.viewBudgets();
    }

    @DeleteMapping("/remove-budget")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeBudget(@RequestParam String title){
        registry.removeBudget(title);
        LOGGER.info("Budget removed from registry: " + title);
    }

}
