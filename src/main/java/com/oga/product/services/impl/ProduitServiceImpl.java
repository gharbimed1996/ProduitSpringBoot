package com.oga.product.services.impl;

import com.oga.product.entities.Produit;
import com.oga.product.repositories.ProduitRepository;
import com.oga.product.services.ProduitService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProduitServiceImpl implements ProduitService {
    private final ProduitRepository produitRepository;

    public ProduitServiceImpl(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }


    @Override
    public Produit addProduit(Produit p) {


        LocalDate now = LocalDate.now();
        p.setModification(now);
        p.setDatecreation(now);
        return produitRepository.save(p);
    }

    @Override
    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);

    }

    @Override
    public Produit updateProduit(Produit p) {
        LocalDate now = LocalDate.now();
        p.setModification(now);
        return updateProduit(p);
    }

    @Override
    public List<Produit> findAll() {
        return produitRepository.findAll();
    }

    @Override
    public List<Produit> retrieveAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public Optional<Produit> findById(Long id) {
        return produitRepository.findById(id);
    }


}
