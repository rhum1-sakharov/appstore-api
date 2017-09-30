package org.rvermorel.api.appstore.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.rvermorel.api.appstore.dtos.ProduitDTO;
import org.rvermorel.api.appstore.dtos.ProduitImageDTO;
import org.rvermorel.api.appstore.entities.ImageProduit;
import org.rvermorel.api.appstore.entities.Produit;

@Mapper
public interface ProduitImageMapper {

    ProduitImageMapper INSTANCE = Mappers.getMapper( ProduitImageMapper.class );

    ProduitImageDTO produitImageToProduitImageDTO(ImageProduit produitImage);
}
