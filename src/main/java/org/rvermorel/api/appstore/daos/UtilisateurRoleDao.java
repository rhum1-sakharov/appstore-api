package org.rvermorel.api.appstore.daos;

import org.rvermorel.api.appstore.entities.Role;
import org.rvermorel.api.appstore.entities.Utilisateur;
import org.rvermorel.api.appstore.entities.UtilisateurRole;
import org.rvermorel.api.appstore.repositories.UtilisateurRepo;
import org.rvermorel.api.appstore.repositories.UtilisateurRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service("utilisateurRoleDao")
@Transactional
public class UtilisateurRoleDao {

    @Autowired
    UtilisateurRoleRepo utilisateurRoleRepo;

    public UtilisateurRole createUtilisateurRole(Role role, Utilisateur utilisateur) {
        UtilisateurRole utilisateurRole = new UtilisateurRole();
        UtilisateurRole utilisateurRoleDb = utilisateurRoleRepo.findByUtilisateurAndRole(utilisateur, role);
        if (Objects.isNull(utilisateurRoleDb)) {
            utilisateurRole.setRole(role);
            utilisateurRole.setUtilisateur(utilisateur);
            utilisateurRole = utilisateurRoleRepo.save(utilisateurRole);
        } else {
            utilisateurRole = utilisateurRoleDb;
        }

        return utilisateurRole;
    }

    public void addRolesToUser(List<Role> roles, Utilisateur utilisateur) {
        roles.forEach(role -> createUtilisateurRole(role, utilisateur));
    }


}
