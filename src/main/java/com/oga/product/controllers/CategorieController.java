package com.oga.product.controllers;

import com.oga.product.entities.Categorie;
import com.oga.product.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins ="http://localhost:4200/")
@RequestMapping("/categorie")
public class CategorieController {


    CategorieService categorieService;

    @Autowired
    public CategorieController(CategorieService categorieService){
        this.categorieService=categorieService;
    }

    @PostMapping (value = "/add-categorie",consumes = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Categorie addCategorie(@RequestBody Categorie c)
    {
        return categorieService.addCategorie(c);
    }
    @PutMapping(value="/modif-categorie", consumes = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Categorie updateCategorie(@RequestBody Categorie c)
    {
        return categorieService.updateCategorie(c);
    }

    @DeleteMapping("/remove-categorie/{id}")
    @ResponseBody
    public void deleteCategorie(@PathVariable("id") Long id) {
        categorieService.deleteCategorie(id);
    }

    @GetMapping("/findCategorie/{id}")
    @ResponseBody
    public Optional<Categorie> findById(@PathVariable("id") Long id) {
        return categorieService.findById(id);
    }
    @GetMapping("/retrieve-all-categories")
    @ResponseBody
    public List<Categorie> retrieveAllCategories() {

        return categorieService.retrieveAllCategories();
    }
    @GetMapping("/search")
    public List<Categorie> search(@RequestParam("q") String query) {

        return categorieService.search(query);
    }
}
