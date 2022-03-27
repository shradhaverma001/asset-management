package com.project.asset.repository;
import org.springframework.data.repository.CrudRepository;
import com.project.asset.model.Category;
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
