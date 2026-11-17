package com.subscribely.category.service;
import org.springframework.stereotype.Service;
import com.subscribely.category.service.CategoryService;
import com.subscribely.category.dto.CategoryRequest;
import com.subscribely.category.dto.CategoryResponse;
import com.subscribely.category.entity.Category;
import com.subscribely.category.repository.CategoryRepository;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    
    @Override
    @Transactional
    public CategoryResponse createCategory(CategoryRequest categoryRequest){
        Category category = new Category(categoryRequest);
        categoryRepository.save(category);
        return new CategoryResponse(category);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryResponse> getAllCategories(){
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(CategoryResponse::new)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryResponse getCategoryById(Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id:" + id));
        return new CategoryResponse(category);
    }

    @Override
    @Transactional
    public CategoryResponse updateCategory(Long id, CategoryRequest categoryRequest){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id:" + id));
        category.setName(categoryRequest.getName());
        category.setDescription(categoryRequest.getDescription());
        categoryRepository.save(category);
        return new CategoryResponse(category);
    }

    @Override
    @Transactional
    public CategoryResponse deleteCategory(Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id:" + id));
        categoryRepository.delete(category);
        return new CategoryResponse(category);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryResponse> searchCategories(String keyword){
        List<Category> categories = categoryRepository.findByNameContainingIgnoreCase(keyword);

        if (categories.isEmpty()) {
            throw new RuntimeException("No categories found with keyword: " + keyword);
        }

        return categories.stream()
                .map(CategoryResponse::new)
                .toList();
    }

}