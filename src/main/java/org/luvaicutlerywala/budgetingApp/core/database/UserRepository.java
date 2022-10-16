package org.luvaicutlerywala.budgetingApp.core.database;

import org.luvaicutlerywala.budgetingApp.core.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, Long> {

    User getUserByName(String name);
    User getUserByUUID(UUID uuid);

}
