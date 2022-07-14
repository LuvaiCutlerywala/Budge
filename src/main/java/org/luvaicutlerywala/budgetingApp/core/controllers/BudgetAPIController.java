package org.luvaicutlerywala.budgetingApp.core.controllers;

import org.luvaicutlerywala.budgetingApp.core.budgetAPI.BudgetRegistry;
import org.luvaicutlerywala.budgetingApp.core.entities.Budget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:8080/"})
public class BudgetAPIController {

    @Autowired
    private BudgetRegistry registry;
    private static final Logger LOGGER = Logger.getLogger("org.luvaicutlerywala.budgetingApp.core.controllers.BudgetAPIController");

    private static boolean checkTitleContent(String content){
        Pattern pattern = Pattern.compile("[A-Za-z]+");
        Matcher matcher = pattern.matcher(content);
        return !matcher.matches();
    }

    @PostMapping("/add-budget")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBudget(@RequestParam String title, @RequestParam double amount) throws IllegalArgumentException{
        if(checkTitleContent(title)){
            throw new IllegalArgumentException("Title does not contain any alphabetic characters");
        }
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
    public void removeBudget(@RequestParam String title) throws IllegalArgumentException{
        if(checkTitleContent(title)){
            throw new IllegalArgumentException("Title does not contain any alphabetic characters");
        }
        registry.removeBudget(title);
        LOGGER.info("Budget removed from registry: " + title);
    }

    @ExceptionHandler
    public ResponseEntity<HttpStatus> illegalArgumentExceptionHandler(IllegalArgumentException illegalArgumentException){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
