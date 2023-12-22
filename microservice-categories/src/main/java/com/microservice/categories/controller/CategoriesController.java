package com.microservice.categories.controller;

import com.microservice.categories.entities.Categories;
import com.microservice.categories.service.ICategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    @Autowired
    ICategoriesService categoriesService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCategories(@RequestBody Categories categories) {
        categoriesService.save(categories);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllCategories() {
        return ResponseEntity.ok(categoriesService.findAll());
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(categoriesService.findById(id));
    }

    @GetMapping("/search/expenses_by_id_category/{id}")
    public ResponseEntity<?> findExpensesByIdCategory(@PathVariable Long id) {
        return ResponseEntity.ok(categoriesService.findExpensesByIdCategories(id));
    }


}
