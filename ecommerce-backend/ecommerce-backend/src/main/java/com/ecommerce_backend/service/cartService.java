package com.ecommerce_backend.service;

import com.ecommerce_backend.Model.Cart;
import com.ecommerce_backend.Model.User;
import com.ecommerce_backend.exception.ProductException;
import com.ecommerce_backend.request.AddItemRequest;

public interface cartService {

	public Cart createCart(User user);
	
	public String addCartItem(Long userId,AddItemRequest req)throws ProductException;
	
	public Cart findUserCart(Long userId);
	
	
	
}
