package com.microservice.expenses.service;

import com.microservice.expenses.entities.Expenses;

import java.util.List;

public interface IExpensesService {

    List<Expenses> findAll();

    Expenses findById(Long id);

    void save(Expenses expenses);

    List<Expenses> findByIdCategory(Long idCategory);

    void delete(Long id);


}
