package com.project.asset.controller;
import java.util.List;
import com.project.asset.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.asset.service.CategoryService;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/category")
    private List<Category> getAllCategory()
    {
        return categoryService.getAllCategory();
    }

    @PutMapping("/category")
    private Category update(@RequestBody Category category)
    {
        categoryService.saveOrUpdate(category);
        return category;
    }

    @PostMapping("/category")
    private void saveCategory(@RequestBody Category category)
    {
        categoryService.saveOrUpdate(category);
    }

}
