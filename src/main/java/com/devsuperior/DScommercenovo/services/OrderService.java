package com.devsuperior.DScommercenovo.services;

import com.devsuperior.DScommercenovo.dto.OrderDTO;
import com.devsuperior.DScommercenovo.dto.OrderItemDTO;
import com.devsuperior.DScommercenovo.entities.*;
import com.devsuperior.DScommercenovo.repositories.OrderItemRepository;
import com.devsuperior.DScommercenovo.repositories.OrderRepository;
import com.devsuperior.DScommercenovo.repositories.ProductRepository;
import com.devsuperior.DScommercenovo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private UserService userService;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id){
        Order order = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO insert(OrderDTO dto) {

        Order order = new Order();

        order.setMoment(Instant.now());//seta o momento atual
        order.setStatus(OrderStatus.WAITING_PAYMENT);
        User user = userService.authenticated();//pega o usuário que está autenticado;
        order.setClient(user);

        for (OrderItemDTO item : dto.getItems()){
            Product product = productRepository.getReferenceById(item.getProductId());
            OrderItem orderItem = new OrderItem(order, product, item.getQuantity(), product.getPrice());
            order.getItems().add(orderItem);
        }

        repository.save(order);
        orderItemRepository.saveAll(order.getItems());

        return new OrderDTO(order);

    }
}
