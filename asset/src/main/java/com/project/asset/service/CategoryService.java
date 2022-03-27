package com.project.asset.service;
import com.project.asset.model.Category;
import com.project.asset.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategory()
    {
        List<Category> category = new ArrayList<Category>();
        categoryRepository.findAll().forEach(category1 -> category.add(category1));
        return category;
    }

    public void saveOrUpdate(Category category)
    {
        categoryRepository.save(category);
    }

    public Category getCategoryById(int id)
    {
        return categoryRepository.findById(id).get();
    }
}
