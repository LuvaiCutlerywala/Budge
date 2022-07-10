package org.luvaicutlerywala.budgetingApp.core;

import org.springframework.context.annotation.Bean;

public class BudgetAPIConfig {

    @Bean
    public static BudgetRegistry initialise(){
        return new BudgetRegistry();
    }

}
