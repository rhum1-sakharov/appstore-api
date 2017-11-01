package org.rvermorel.api.appstore.controllers;

import org.rvermorel.api.appstore.entities.Image;
import org.rvermorel.api.appstore.entities.Produit;
import org.rvermorel.api.appstore.repositories.ImageRepo;
import org.rvermorel.api.appstore.repositories.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(path = "image")
public class ImageController {

    @Autowired
    private ImageRepo imageRepo;

    @GetMapping(path = "/{id}")
    public @ResponseBody
    byte[] getImage(@PathVariable("id") Integer id) {

       Image image = imageRepo.findOne(id);
        if (!Objects.isNull(image)) {
            return image.getImage();
        }

        return null;
    }

}
