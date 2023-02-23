package com.oga.product.Test;

import com.oga.product.entities.Categorie;
import com.oga.product.services.CategorieService;
import com.oga.product.services.impl.CategorieServiceImpl;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;



@SpringBootTest
 class CategorieTest {

    @Autowired
    private CategorieService categorieService;

    @Test
    @Order(2)
     void TestGetCategories() {

        List<Categorie> categories = categorieService.retrieveAllCategories();
        assertThat(categories).isNotNull();
    }
    @Test
    @Order(3)
     void TestGetCategorieById() {

        Optional<Categorie> categories = categorieService.findById(1L);
        assertThat(categories).isNotNull();
    }

    @Test
    @Order(1)
    void testAddCategorie() {
        Categorie expectedCategorie = new Categorie.Builder().nom("aaa").qt(10).build();

        Categorie savedCategorie = categorieService.addCategorie(expectedCategorie);
        assertNotNull(savedCategorie);
        assertNotNull(savedCategorie.getId());

        assertEquals(expectedCategorie.getNom(), savedCategorie.getNom());
        assertEquals(expectedCategorie.getQt(), savedCategorie.getQt());



    }




}
