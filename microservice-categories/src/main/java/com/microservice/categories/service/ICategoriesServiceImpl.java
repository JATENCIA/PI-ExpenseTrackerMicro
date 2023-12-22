package com.microservice.categories.service;

import com.microservice.categories.client.ExpensesClient;
import com.microservice.categories.dto.ExpensesDTO;
import com.microservice.categories.entities.Categories;
import com.microservice.categories.http.response.ExpensesByCategoryResponse;
import com.microservice.categories.persistence.ICategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.microservice.categories.http.response.ExpensesByCategoryResponse.*;

@Service
public class ICategoriesServiceImpl implements ICategoriesService {
    @Autowired
    private ICategoriesRepository categoriesRepository;
    @Autowired
    private ExpensesClient expensesClient;

    @Override
    public List<Categories> findAll() {
        return (List<Categories>) categoriesRepository.findAll();
    }

    @Override
    public Optional<Categories> findById(Long id) {
        return Optional.of(categoriesRepository.findById(id).orElseThrow());
    }

    @Override
    public void save(Categories categories) {
        categoriesRepository.save(categories);
    }

    @Override
    public ExpensesByCategoryResponse findExpensesByIdCategories(Long idCategory) {

        Categories categories = categoriesRepository.findById(idCategory).orElse(new Categories());
        List<ExpensesDTO> expensesDTOList = expensesClient.findAllExpenseByCategory(idCategory);

        return ExpensesByCategoryResponse.builder()
                .categoryName(categories.getName())
                .expensesDTOList(expensesDTOList)
                .build();

    }
}
