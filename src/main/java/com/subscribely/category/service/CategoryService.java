package com.subscribely.category.service;
import com.subscribely.category.dto.CategoryRequest;
import com.subscribely.category.dto.CategoryResponse;
import java.util.List;

public interface CategoryService{

    CategoryResponse createCategory(CategoryRequest categoryRequest);

    List<CategoryResponse> getAllCategories();

    CategoryResponse getCategoryById(Long id);

    CategoryResponse updateCategory(Long id, CategoryRequest categoryRequest);

    CategoryResponse deleteCategory(Long id);

    List<CategoryResponse> searchCategories(String keyword);
}