package com.microservice.expenses.service;

import com.microservice.expenses.entities.Expenses;
import com.microservice.expenses.persistence.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class IExpensesServiceImpl implements IExpensesService {
    @Autowired
    private ExpensesRepository expensesRepository;

    @Override
    public List<Expenses> findAll() {
        return (List<Expenses>) expensesRepository.findAll();
    }

    @Override
    public Expenses findById(Long id) {
        return expensesRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Expenses expenses) {
        expensesRepository.save(expenses);
    }

    @Override
    public List<Expenses> findByIdCategory(Long idCategory) {
        return expensesRepository.findAllByCategoryId(idCategory);
    }

    @Override
    public void delete(Long id) {
        expensesRepository.deleteById(id);
    }


}
