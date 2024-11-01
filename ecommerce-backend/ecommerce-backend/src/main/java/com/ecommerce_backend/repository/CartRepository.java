package com.ecommerce_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce_backend.Model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

}
