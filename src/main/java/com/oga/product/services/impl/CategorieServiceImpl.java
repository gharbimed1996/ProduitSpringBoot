package com.oga.product.services.impl;

import com.oga.product.entities.Categorie;
import com.oga.product.repositories.CategorieRepository;
import com.oga.product.services.CategorieService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CategorieServiceImpl implements CategorieService {

    private final CategorieRepository categorieRepository;

    public CategorieServiceImpl(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @Override
    public Categorie addCategorie(Categorie c) {

        LocalDate now = LocalDate.now();
        c.setDatemodification(now);
        c.setDatecreation(now);
        return categorieRepository.save(c);

    }

    @Override
    public void deleteCategorie(Long id) {
        categorieRepository.deleteById(id);

    }

    @Override
    public Categorie updateCategorie(Categorie c) {
        LocalDate now = LocalDate.now();
        c.setDatemodification(now);
        return updateCategorie(c);
    }

    @Override
    public Optional<Categorie> findById(Long id) {

        return categorieRepository.findById(id);
    }

    @Override
    public List<Categorie> retrieveAllCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public List<Categorie> search(String query) {
        return categorieRepository.findByNomContainingIgnoreCase(query);
    }
}