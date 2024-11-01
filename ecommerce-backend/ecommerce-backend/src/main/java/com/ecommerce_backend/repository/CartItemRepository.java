package com.ecommerce_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce_backend.Model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{

}
