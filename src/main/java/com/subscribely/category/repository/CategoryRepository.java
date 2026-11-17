package com.subscribely.category.repository;
import com.subscribely.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>{

    public Category findByName(String name);
    boolean existsByName(String name);
    List<Category> findByNameContainingIgnoreCase(String keyword);

}