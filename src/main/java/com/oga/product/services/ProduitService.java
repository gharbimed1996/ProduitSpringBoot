package com.oga.product.services;


import com.oga.product.entities.Produit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ProduitService {

    Produit addProduit(Produit p);

    void deleteProduit(Long id);

    Produit updateProduit(Produit c);

    List<Produit> findAll();

    List<Produit> retrieveAllProduits();
    Optional<Produit> findById(Long id);



}
