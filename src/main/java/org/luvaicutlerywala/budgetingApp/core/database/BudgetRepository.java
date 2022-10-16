package org.luvaicutlerywala.budgetingApp.core.database;

import org.luvaicutlerywala.budgetingApp.core.entities.Budget;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BudgetRepository extends CrudRepository<Budget, Long> {

    Budget getBudgetById(long id);
    Budget getBudgetByUUID(UUID uuid);

}
