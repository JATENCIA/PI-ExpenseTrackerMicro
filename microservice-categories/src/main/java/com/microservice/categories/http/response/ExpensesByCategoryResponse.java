package com.microservice.categories.http.response;

import com.microservice.categories.dto.ExpensesDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpensesByCategoryResponse {

    private String categoryName;
    private List<ExpensesDTO> expensesDTOList;

}
