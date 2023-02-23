package com.oga.product.repositories;

import com.oga.product.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Long> {


    List<Categorie> findByNomContainingIgnoreCase(String query);
}
