package com.devsuperior.DScommercenovo.services;

import com.devsuperior.DScommercenovo.dto.ProductDTO;
import com.devsuperior.DScommercenovo.entities.Product;
import com.devsuperior.DScommercenovo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product entity = repository.findById(id).get();
        return new ProductDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable){
        Page<Product> products = repository.findAll(pageable);
        return products.map(x -> new ProductDTO(x));
    }

    


}
