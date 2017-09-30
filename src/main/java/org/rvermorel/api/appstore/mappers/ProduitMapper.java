package org.rvermorel.api.appstore.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.rvermorel.api.appstore.dtos.ProduitDTO;
import org.rvermorel.api.appstore.entities.Produit;

@Mapper
public interface ProduitMapper {

    ProduitMapper INSTANCE = Mappers.getMapper( ProduitMapper.class );

    ProduitDTO produitToProduitDTO(Produit produit);
}
