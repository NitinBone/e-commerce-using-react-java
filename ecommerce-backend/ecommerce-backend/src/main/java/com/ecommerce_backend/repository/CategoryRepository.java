package com.ecommerce_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce_backend.Model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	public Category findByName(String name);
	
	@Query("Select c from Category c Where c.name=:name And c.parentCategory.name=:parentCategoryName")
	public Category findByNameAndParant(@Param("name") String name,
			@Param("parentCategoryName") String parantCategoryName);
}
