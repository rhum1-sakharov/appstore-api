package org.rvermorel.api.appstore.repositories;

import org.rvermorel.api.appstore.entities.Image;
import org.rvermorel.api.appstore.entities.Role;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<Role,Integer>{

    Role findByCode(String code);

    @Modifying
    @Query("update Role r set r.id=?2 where r.id=?1")
     void updateId(int oldId,int newId);
}
