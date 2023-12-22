package com.microservice.categories.service;

import com.microservice.categories.entities.Categories;
import com.microservice.categories.http.response.ExpensesByCategoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ICategoriesService {

    List<Categories> findAll();

    Optional<Categories> findById(Long id);

    void save(Categories categories);

    ExpensesByCategoryResponse findExpensesByIdCategories(Long idCategory);

}
