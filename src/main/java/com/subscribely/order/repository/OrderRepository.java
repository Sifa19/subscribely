package com.subscribely.order.repository;

import com.subscribely.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public class OrderRepository extends JpaRepository<Order,Long>{

}