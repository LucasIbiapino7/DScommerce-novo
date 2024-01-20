package com.devsuperior.DScommercenovo.repositories;

import com.devsuperior.DScommercenovo.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //<Tipo da entidade, tipo da chave primária da entidade>
    @Query("SELECT obj " +
            "FROM Product obj " +
            "WHERE UPPER(obj.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<Product> searchByName(String name, Pageable pageable);

    @Query("SELECT obj " +
            "FROM Product obj " +
            "JOIN FETCH obj.categories " +
            "WHERE obj.id = :id")
    Optional<Product> searchById(Long id);
}
