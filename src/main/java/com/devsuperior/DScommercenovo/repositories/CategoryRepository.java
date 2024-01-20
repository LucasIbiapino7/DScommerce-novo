package com.devsuperior.DScommercenovo.repositories;

import com.devsuperior.DScommercenovo.entities.Category;
import com.devsuperior.DScommercenovo.entities.User;
import com.devsuperior.DScommercenovo.projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
