package com.devsuperior.DScommercenovo.services;

import com.devsuperior.DScommercenovo.dto.CategoryDTO;
import com.devsuperior.DScommercenovo.dto.ProductDTO;
import com.devsuperior.DScommercenovo.dto.ProductMinDTO;
import com.devsuperior.DScommercenovo.entities.Category;
import com.devsuperior.DScommercenovo.entities.Product;
import com.devsuperior.DScommercenovo.repositories.CategoryRepository;
import com.devsuperior.DScommercenovo.repositories.ProductRepository;
import com.devsuperior.DScommercenovo.services.exceptions.DatabaseException;
import com.devsuperior.DScommercenovo.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll(){
        List<Category> result = repository.findAll();
        return result.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
    }
}
