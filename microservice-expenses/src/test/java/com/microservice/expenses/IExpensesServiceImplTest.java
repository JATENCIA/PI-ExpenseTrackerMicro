package com.microservice.expenses;

import com.microservice.expenses.entities.Expenses;
import com.microservice.expenses.persistence.ExpensesRepository;
import com.microservice.expenses.service.IExpensesServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class IExpensesServiceImplTest {

    @Mock
    private ExpensesRepository expensesRepositoryMock;

    @InjectMocks
    private IExpensesServiceImpl expensesService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Test findAll method to retrieve all expenses")
    public void testFindAll_ShouldRetrieveAllExpenses() {

        // GIVEN
        List<Expenses> mockExpensesList = Arrays.asList(
                Expenses.builder().id(1L).amount(100.0).categoryId(1L).date("2023-12-20").build(),
                Expenses.builder().id(2L).amount(75.5).categoryId(2L).date("2023-12-21").build(),
                Expenses.builder().id(3L).amount(50.0).categoryId(1L).date("2023-12-22").build()
        );
        when(expensesRepositoryMock.findAll()).thenReturn(mockExpensesList);

        // WHEN
        List<Expenses> result = expensesService.findAll();

        // THEN
        assertEquals(3, result.size());
        assertEquals(75.5, result.get(1).getAmount());
        assertEquals("2023-12-22", result.get(2).getDate());

    }

    @Test
    @DisplayName("Test findById method to retrieve an expense by ID")
    public void testFindById_ShouldRetrieveExpenseById() {

        // GIVEN
        Expenses mockExpense = Expenses.builder().id(1L).amount(100.0).categoryId(1L).date("2023-12-20").build();
        when(expensesRepositoryMock.findById(1L)).thenReturn(Optional.of(mockExpense));

        // WHEN
        Expenses result = expensesService.findById(1L);

        // THEN
        assertNotNull(result);
        assertEquals(100.0, result.getAmount());
        assertEquals("2023-12-20", result.getDate());

    }

    @Test
    @DisplayName("Test save method to add a new expense")
    public void testSave_ShouldAddNewExpense() {

        // GIVEN
        Expenses expenseToSave = Expenses.builder().amount(50.0).categoryId(3L).date("2023-12-22").build();

        // WHEN
        expensesService.save(expenseToSave);

        // THEN
        verify(expensesRepositoryMock, times(1)).save(expenseToSave);

    }

    @Test
    @DisplayName("Test delete method to remove an expense by ID")
    public void testDelete_ShouldRemoveExpenseById() {

        // GIVEN
        doNothing().when(expensesRepositoryMock).deleteById(1L);

        // WHEN
        expensesService.delete(1L);

        // THEN
        verify(expensesRepositoryMock, times(1)).deleteById(1L);

    }
}
