package org.rvermorel.api.appstore.repositories;

import org.rvermorel.api.appstore.entities.Produit;
import org.springframework.data.repository.CrudRepository;

public interface ProduitRepo extends CrudRepository<Produit,Integer>{
}
