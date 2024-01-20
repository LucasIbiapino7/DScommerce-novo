package com.devsuperior.DScommercenovo.repositories;

import com.devsuperior.DScommercenovo.entities.Order;
import com.devsuperior.DScommercenovo.entities.OrderItem;
import com.devsuperior.DScommercenovo.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
