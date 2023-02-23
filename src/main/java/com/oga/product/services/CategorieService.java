package com.oga.product.services;

import com.oga.product.entities.Categorie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface CategorieService {

    Categorie addCategorie(Categorie c);

    void deleteCategorie(Long id);

    Categorie updateCategorie(Categorie c);

    Optional<Categorie> findById(Long id);

    List<Categorie> retrieveAllCategories();


    List<Categorie> search(String query);
}
