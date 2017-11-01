package org.rvermorel.api.appstore.models;

import org.rvermorel.api.appstore.entities.Utilisateur;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class JwtUser implements UserDetails {

    private String login;
    private String password;
    private String lastname;
    private String firstname;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtUser(Utilisateur utilisateur) {

        this.login = utilisateur.getLogin();
        this.firstname = utilisateur.getFirstname();
        this.lastname = utilisateur.getLastname();
        this.password = utilisateur.getPassword();
        this.authorities = utilisateur.getUtilisateurRoleList()
                .stream()
                .map(ur -> ur.getRole().getCode())
                .map(code -> new SimpleGrantedAuthority(code))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
