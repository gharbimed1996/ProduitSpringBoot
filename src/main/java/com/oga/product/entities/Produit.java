package com.oga.product.entities;

import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor

public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "qt")
    private int qt;
    @Column(name = "disponible")
    private Boolean disponible;
    @Column(name = "datecreation")
    private LocalDate datecreation;
    @Column(name = "modification")
    private LocalDate modification;

    @ManyToOne(fetch = FetchType.LAZY)
    private Categorie categorie;
}
