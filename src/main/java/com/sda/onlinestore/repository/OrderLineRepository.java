package com.sda.onlinestore.repository;

import com.sda.onlinestore.entity.OrderLine;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
}
