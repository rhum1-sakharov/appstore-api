package org.rvermorel.api.appstore.entities;

import javax.persistence.*;

@Entity
@Table(name = "images_produits")
public class ImageProduit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="id_produit",insertable = false,updatable = false)
    private Integer idProduit;
    @Column(name="id_image",insertable = false,updatable = false)
    private Integer idImage;

    @ManyToOne
    @JoinColumn(name = "id_image", referencedColumnName = "id")
    private Image image;

    @ManyToOne
    @JoinColumn(name = "id_produit", referencedColumnName = "id")
    private Produit produit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public Integer getIdImage() {
        return idImage;
    }

    public void setIdImage(Integer idImage) {
        this.idImage = idImage;
    }


    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }


    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
