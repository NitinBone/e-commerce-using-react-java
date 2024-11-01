package com.ecommerce_backend.service;

import com.ecommerce_backend.Model.Cart;
import com.ecommerce_backend.Model.CartItem;
import com.ecommerce_backend.Model.Product;
import com.ecommerce_backend.exception.CartItemException;
import com.ecommerce_backend.exception.UserException;

public interface CartItemService {

	public CartItem createCartItem(CartItem cartItem);
	
	public CartItem updateCartItem(Long userId,long id,CartItem cartItem)throws CartItemException,UserException;
	
	public CartItem isCartItemExist(Cart cart,Product product,String size,Long userId);

	public void removeCartItem(Long UserId,Long cartItemId) throws CartItemException, UserException;
	
	public CartItem findCartItemById(Long cartItemId)throws CartItemException;
	
	
}
