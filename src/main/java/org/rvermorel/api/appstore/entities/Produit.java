package org.rvermorel.api.appstore.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="produits")
public class Produit {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String libelle;
    private String description;
    private BigDecimal prix;

    @Column(name = "id_image", insertable = false,updatable = false)
    private Integer idImage;

    @ManyToOne
    @JoinColumn(name = "id_image",referencedColumnName = "id")
    private Image image;


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


    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Integer getIdImage() {
        return idImage;
    }

    public void setIdImage(Integer idImage) {
        this.idImage = idImage;
    }
}
