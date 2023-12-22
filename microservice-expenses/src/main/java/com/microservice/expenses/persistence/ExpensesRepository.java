package com.microservice.expenses.persistence;

import com.microservice.expenses.entities.Expenses;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpensesRepository extends CrudRepository<Expenses, Long> {
    List<Expenses> findAllByCategoryId(Long id);

}


