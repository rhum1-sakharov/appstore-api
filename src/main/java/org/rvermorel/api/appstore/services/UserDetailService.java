package org.rvermorel.api.appstore.services;

import org.rvermorel.api.appstore.entities.Utilisateur;
import org.rvermorel.api.appstore.models.JwtUser;
import org.rvermorel.api.appstore.repositories.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service("uds")
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UtilisateurRepo utilisateurRepo;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepo.findByLogin(login);
        if(!Objects.isNull(utilisateur)){
            return  new JwtUser(utilisateur);
        }
        return null;
    }

}
