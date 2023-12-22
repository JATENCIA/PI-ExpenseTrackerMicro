package com.microservice.categories.client;

import com.microservice.categories.dto.ExpensesDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-expenses", url = "localhost:8090/api/expenses")
public interface ExpensesClient {
    @GetMapping("/search-by-category/{idCategory}")
    List<ExpensesDTO> findAllExpenseByCategory(@PathVariable Long idCategory);

}
