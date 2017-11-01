package org.rvermorel.api.appstore.repositories;

import org.rvermorel.api.appstore.entities.Role;
import org.rvermorel.api.appstore.entities.Utilisateur;
import org.rvermorel.api.appstore.entities.UtilisateurRole;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UtilisateurRoleRepo extends CrudRepository<UtilisateurRole, Integer> {


    UtilisateurRole findByUtilisateurAndRole(Utilisateur utilisateur, Role role);

}
