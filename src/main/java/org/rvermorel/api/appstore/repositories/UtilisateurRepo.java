package org.rvermorel.api.appstore.repositories;

import org.rvermorel.api.appstore.entities.Role;
import org.rvermorel.api.appstore.entities.Utilisateur;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UtilisateurRepo extends CrudRepository<Utilisateur,Integer>{

    Utilisateur findByLogin(String login);

    @Modifying
    @Query("update Utilisateur u set u.id=?2 where u.id=?1")
     void updateId(int oldId, int newId);
}
