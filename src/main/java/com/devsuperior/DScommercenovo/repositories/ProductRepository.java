package com.devsuperior.DScommercenovo.repositories;

import com.devsuperior.DScommercenovo.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //<Tipo da entidade, tipo da chave primária da entidade>

}
