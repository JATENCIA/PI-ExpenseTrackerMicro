package com.microservice.categories;

import com.microservice.categories.client.ExpensesClient;
import com.microservice.categories.dto.ExpensesDTO;
import com.microservice.categories.entities.Categories;
import com.microservice.categories.http.response.ExpensesByCategoryResponse;
import com.microservice.categories.persistence.ICategoriesRepository;
import com.microservice.categories.service.ICategoriesServiceImpl;
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

public class ICategoriesServiceImplTest {

    @Mock
    private ICategoriesRepository categoriesRepositoryMock;

    @Mock
    private ExpensesClient expensesClientMock;

    @InjectMocks
    private ICategoriesServiceImpl categoriesService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    @DisplayName("Test findAll method to retrieve all categories")
    public void testFindAll_ShouldRetrieveAllCategories() {

        // GIVEN
        List<Categories> mockCategoriesList = Arrays.asList(
                Categories.builder().id(1L).name("Category 1").build(),
                Categories.builder().id(2L).name("Category 2").build()
        );
        when(categoriesRepositoryMock.findAll()).thenReturn(mockCategoriesList);

        // WHEN
        List<Categories> result = categoriesService.findAll();

        // THEN
        assertEquals(2, result.size());
        assertEquals("Category 2", result.get(1).getName());

    }


    @Test
    @DisplayName("Test findById method to retrieve a category by ID")
    public void testFindById_ShouldRetrieveCategoryById() {

        // GIVEN
        Categories mockCategory = Categories.builder().id(1L).name("Category 1").build();
        when(categoriesRepositoryMock.findById(1L)).thenReturn(Optional.of(mockCategory));

        // WHEN
        Optional<Categories> result = categoriesService.findById(1L);

        // THEN
        assertNotNull(result);
        assertEquals("Category 1", result.get().getName());

    }


    @Test
    @DisplayName("Test findExpensesByIdCategories method to retrieve expenses by category")
    public void testFindExpensesByIdCategories_ShouldRetrieveExpensesByCategory() {

        // GIVEN
        Long categoryId = 1L;
        Categories mockCategory = Categories.builder().id(categoryId).name("Category 1").build();
        when(categoriesRepositoryMock.findById(categoryId)).thenReturn(Optional.of(mockCategory));

        List<ExpensesDTO> mockExpensesDTOList = Arrays.asList(
                ExpensesDTO.builder().date("2023-12-20").amount(100.0).categoryId(categoryId).build(),
                ExpensesDTO.builder().date("2023-12-21").amount(75.5).categoryId(categoryId).build()
        );
        when(expensesClientMock.findAllExpenseByCategory(categoryId)).thenReturn(mockExpensesDTOList);

        // WHEN
        ExpensesByCategoryResponse result = categoriesService.findExpensesByIdCategories(categoryId);

        // THEN
        assertNotNull(result);
        assertEquals("Category 1", result.getCategoryName());
        assertEquals(2, result.getExpensesDTOList().size());
        assertEquals(75.5, result.getExpensesDTOList().get(1).getAmount());

    }
}
