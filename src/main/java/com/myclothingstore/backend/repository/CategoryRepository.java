package com.myclothingstore.backend.repository;

import com.myclothingstore.backend.entity.CategoryEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface CategoryRepository  extends JpaRepository<CategoryEntity, Integer> {
    Optional<CategoryEntity> findByName(String categoryName);
}
