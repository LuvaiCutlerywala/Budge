package org.luvaicutlerywala.budgetingApp.core.budgetAPI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BudgetAPIConfig {

    @Bean
    public static BudgetRegistry initialise(){
        return new BudgetRegistry();
    }

}
