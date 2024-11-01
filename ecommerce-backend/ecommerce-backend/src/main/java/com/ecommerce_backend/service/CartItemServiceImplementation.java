package com.ecommerce_backend.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecommerce_backend.Model.Cart;
import com.ecommerce_backend.Model.CartItem;
import com.ecommerce_backend.Model.Product;
import com.ecommerce_backend.exception.CartItemException;
import com.ecommerce_backend.exception.UserException;
import com.ecommerce_backend.repository.CartItemRepository;

public class CartItemServiceImplementation implements CartItemService{

	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Override
	public CartItem createCartItem(CartItem cartItem) {
		
		return null;
	}

	@Override
	public CartItem updateCartItem(Long userId, long id, CartItem cartItem) throws CartItemException, UserException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCartItem(Long UserId, Long cartItemId) throws CartItemException, UserException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CartItem findCartItemById(Long cartItemId) throws CartItemException {
		// TODO Auto-generated method stub
		return null;
	}

}
