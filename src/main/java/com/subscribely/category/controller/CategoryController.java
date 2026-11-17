package com.subscribely.category.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.subscribely.category.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.subscribely.category.dto.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController{

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/")
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest category){
        CategoryResponse categoryResponse = categoryService.createCategory(category);
        return new ResponseEntity<>(categoryResponse, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryResponse>> getAllCategories(){
        List<CategoryResponse> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategory(@PathVariable Long id){
        CategoryResponse category = categoryService.getCategoryById(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CategoryResponse> updateCategory(@PathVariable Long id,@RequestBody CategoryRequest categoryRequest){
        CategoryResponse category = categoryService.updateCategory(id, categoryRequest);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryResponse> deleteCategory(@PathVariable Long id){
        CategoryResponse category = categoryService.deleteCategory(id);
        return new ResponseEntity<>(category, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public ResponseEntity<List<CategoryResponse>> searchCategories(@RequestParam String name){
        List<CategoryResponse> category = categoryService.searchCategories(name);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }


}