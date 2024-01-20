package com.devsuperior.DScommercenovo.controllers;

import com.devsuperior.DScommercenovo.dto.CategoryDTO;
import com.devsuperior.DScommercenovo.dto.ProductDTO;
import com.devsuperior.DScommercenovo.dto.ProductMinDTO;
import com.devsuperior.DScommercenovo.services.CategoryService;
import com.devsuperior.DScommercenovo.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    //busca paginada - atores (Usuário anônimo, Cliente, Admin)
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll(){
        List<CategoryDTO> dto = service.findAll();
        return ResponseEntity.ok(dto);
    }
}
