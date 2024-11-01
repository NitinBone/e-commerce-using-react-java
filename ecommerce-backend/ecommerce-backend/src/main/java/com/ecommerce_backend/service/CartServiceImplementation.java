package com.ecommerce_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce_backend.Model.Cart;
import com.ecommerce_backend.Model.CartItem;
import com.ecommerce_backend.Model.User;
import com.ecommerce_backend.exception.ProductException;
import com.ecommerce_backend.repository.CartRepository;
import com.ecommerce_backend.request.AddItemRequest;

@Service
public class CartServiceImplementation implements cartService{

	@Autowired
	private CartRepository cartRepository;
	private CartItemService cartItemService;
	
	@Override
	public Cart createCart(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addCartItem(Long userId, AddItemRequest req) throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart findUserCart(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
