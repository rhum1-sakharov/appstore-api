package org.rvermorel.api.appstore.daos;

import org.rvermorel.api.appstore.entities.Role;
import org.rvermorel.api.appstore.entities.Utilisateur;
import org.rvermorel.api.appstore.repositories.RoleRepo;
import org.rvermorel.api.appstore.repositories.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("utilisateurDao")
@Transactional
public class UtilisateurDao {

    @Autowired
    UtilisateurRepo utilisateurRepo;

    public Utilisateur createUtilisateur(int id, String login, String email,String password, String lastname,String firstname){
        Utilisateur utilisateur = new Utilisateur();
        Utilisateur utilisateurDb = utilisateurRepo.findByLogin(login);
        if(Objects.isNull(utilisateurDb)){
            utilisateur.setLogin(login);
            utilisateur.setEmail(email);
            utilisateur.setFirstname(firstname);
            utilisateur.setLastname(lastname);
            utilisateur.setPassword(password);
            utilisateur = utilisateurRepo.save(utilisateur);
        }else{
            utilisateur = utilisateurDb;
        }
        utilisateurRepo.updateId(utilisateur.getId(),id);
        utilisateur = utilisateurRepo.findByLogin(login);


        return utilisateur;
    }


}
