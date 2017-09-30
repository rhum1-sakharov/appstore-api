package org.rvermorel.api.appstore.controllers;

import org.rvermorel.api.appstore.dtos.ProduitDTO;
import org.rvermorel.api.appstore.entities.Produit;
import org.rvermorel.api.appstore.mappers.ProduitMapper;
import org.rvermorel.api.appstore.repositories.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "produit")
public class ProduitController {

    @Autowired
    private ProduitRepo produitRepo;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<ProduitDTO> getAllProduits() {

        List<ProduitDTO> produitDTOList = new ArrayList<>();
        produitRepo.findAll().forEach(item -> produitDTOList.add(ProduitMapper.INSTANCE.produitToProduitDTO(item)));

        return produitDTOList;
    }

}
