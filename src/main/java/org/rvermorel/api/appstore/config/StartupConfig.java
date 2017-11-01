package org.rvermorel.api.appstore.config;

import org.rvermorel.api.appstore.daos.RoleDao;
import org.rvermorel.api.appstore.daos.UtilisateurDao;
import org.rvermorel.api.appstore.daos.UtilisateurRoleDao;
import org.rvermorel.api.appstore.entities.Role;
import org.rvermorel.api.appstore.entities.Utilisateur;
import org.rvermorel.api.appstore.repositories.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.rvermorel.api.appstore.daos.RoleDao.ROLE_USER;

@Configuration
public class StartupConfig {

    @Autowired
    @Qualifier("roleDao")
    private RoleDao roleDao;

    @Autowired
    @Qualifier("utilisateurDao")
    private UtilisateurDao utilisateurDao;

    @Autowired
    @Qualifier("utilisateurRoleDao")
    private UtilisateurRoleDao utilisateurRoleDao;

    @PostConstruct
    public void init() {

        //initialiser les roles par défaut
        List<Role> roles = roleDao.initRoles();

        //initialiser l'admin
        Utilisateur userAdmin = utilisateurDao.createUtilisateur(1, "admin", "admin@rvl-appstore.com", "admin", "Appstore", "Admin");
        //initaliser l'utilisateur simple
        Utilisateur userSimple = utilisateurDao.createUtilisateur(2, "test", "test@rvl-appstore.com", "test", "Appstore", "Test");

        //assigner tous les roles à l'administrateur
        utilisateurRoleDao.addRolesToUser(roles, userAdmin);

        //assigner le role utilisateur à userSimple
        List<Role> rolesUser = roles.stream().filter(role -> role.getCode().equalsIgnoreCase(ROLE_USER)).collect(Collectors.toList());
        utilisateurRoleDao.addRolesToUser(rolesUser, userSimple);

    }

}


