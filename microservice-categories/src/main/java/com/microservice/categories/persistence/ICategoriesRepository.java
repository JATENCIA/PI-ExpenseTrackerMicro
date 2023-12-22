package com.microservice.categories.persistence;

import com.microservice.categories.entities.Categories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICategoriesRepository extends CrudRepository<Categories, Long> {
}
