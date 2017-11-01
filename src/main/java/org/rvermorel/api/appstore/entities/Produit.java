package org.rvermorel.api.appstore.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="produits")
public class Produit {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String libelle;
    private String description;
    private BigDecimal prix;

    @OneToMany(mappedBy = "produit")
    private List<ImageProduit> imageProduitList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }


    public List<ImageProduit> getImageProduitList() {
        return imageProduitList;
    }

    public void setImageProduitList(List<ImageProduit> imageProduitList) {
        this.imageProduitList = imageProduitList;
    }
}
