package org.rvermorel.api.appstore.daos;

import org.rvermorel.api.appstore.entities.Role;
import org.rvermorel.api.appstore.repositories.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("roleDao")
@Transactional
public class RoleDao {

    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_USER = "ROLE_UTILISATEUR";

    @Autowired
    RoleRepo roleRepo;

    public Role createRole(int id, String code, String libelle) {
        Role role = new Role();
        Role roleDb = roleRepo.findByCode(code);
        if (Objects.isNull(roleDb)) {
            role.setCode(code);
            role.setLibelle(libelle);
            role = roleRepo.save(role);
        } else {
            role = roleDb;
        }
        roleRepo.updateId(role.getId(), id);
        role = roleRepo.findByCode(code);

        return role;
    }

    public List<Role> initRoles() {
        List<Role> roles = new ArrayList<>();
        roles.add(createRole(1, ROLE_ADMIN, "Administrateur"));
        roles.add(createRole(2, ROLE_USER, "Utilisateur"));
        return roles;
    }
}
