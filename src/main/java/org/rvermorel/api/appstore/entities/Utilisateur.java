package org.rvermorel.api.appstore.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="utilisateurs")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String login;
    private String password;
    private String email;
    private String lastname;
    private String firstname;

    @OneToMany(mappedBy = "utilisateur")
    private List<UtilisateurRole> utilisateurRoleList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public List<UtilisateurRole> getUtilisateurRoleList() {
        return utilisateurRoleList;
    }

    public void setUtilisateurRoleList(List<UtilisateurRole> utilisateurRoleList) {
        this.utilisateurRoleList = utilisateurRoleList;
    }
}
