package com.devsuperior.DScommercenovo.services;

import com.devsuperior.DScommercenovo.dto.OrderDTO;
import com.devsuperior.DScommercenovo.entities.Order;
import com.devsuperior.DScommercenovo.repositories.OrderRepository;
import com.devsuperior.DScommercenovo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id){
        Order order = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO(order);
    }

}
