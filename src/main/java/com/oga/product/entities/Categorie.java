package com.oga.product.entities;

import jakarta.persistence.*;

import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Categorie(Builder builder) {
        this.nom = builder.nom;
        this.qt = builder.qt;
    }

    @Column(name = "nom")
    private String nom;

    @Column(name = "qt")
    private int qt;

    @Column(name = "datecreation")
    private LocalDate datecreation;

    @Column(name = "datemodification")
    private LocalDate datemodification;

    public static class Builder {
        private String nom;
        private int qt;

        public Builder nom(String nom) {
            this.nom = nom;
            return this;
        }

        public Builder qt(int qt) {
            this.qt = qt;
            return this;
        }

        public Categorie build() {
            return new Categorie(this);
        }


        @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
        private List<Produit> produits;

    }
}
