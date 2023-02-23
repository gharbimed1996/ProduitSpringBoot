package com.oga.product.controllers;


import com.oga.product.entities.Produit;
import com.oga.product.excel.ProduitExcel;
import com.oga.product.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/produit")
public class ProduitController {
    ProduitService produitService;

    @Autowired
    public ProduitController(ProduitService produitService){
        this.produitService= produitService;
    }

    @PostMapping(value = "/add-produit",consumes = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Produit addProduit(@RequestBody Produit p)
    {
        return produitService.addProduit(p);
    }
    @PutMapping("/modif-produit/{id}")
    @ResponseBody
    public Produit updateProduit(@RequestBody Produit p)
    {
        return produitService.updateProduit(p);
    }

    @DeleteMapping("/remove-produit/{id}")
    @ResponseBody
    public void deleteProduit(@PathVariable("id") Long id) {
        produitService.deleteProduit(id);
    }

    @GetMapping("/retrieve-all-produits")
    @ResponseBody
    public List<Produit> retrieveAllProduits() {
        return produitService.retrieveAllProduits();
    }
    @GetMapping("/findProduit/{id}")
    @ResponseBody
    public Optional<Produit> findById(@PathVariable("id") Long id) {
        return produitService.findById(id);
    }

    @GetMapping("/produits/download")
    public ResponseEntity<InputStreamResource> downloadProduits() throws IOException {
        List<Produit> produits = produitService.findAll();

        ByteArrayInputStream in = ProduitExcel.produitsToExcel(produits);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=produits.xlsx");

        return ResponseEntity
                .ok()//200
                .headers(headers)
                .body(new InputStreamResource(in));
    }
}
