package com.ecommerce_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce_backend.Model.Address;
import com.ecommerce_backend.Model.Order;
import com.ecommerce_backend.Model.User;
import com.ecommerce_backend.exception.OrderException;

@Service
public class OrderServiceImplementation implements OrderService{

//	@Autowired
//	private CartRepository cartRepository;
//	
//	@Autowired
//	private cartItemService cartItemService;
	
	@Autowired
	private ProductService productService;
	
	@Override
	public Order createOrder(User user, Address shippingAdress) {
		
		return null;
	}

	@Override
	public Order findOrderById(Long orderld) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> usersOrderHistory(Long userld) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order placedOrder(Long orderld) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order confirmedOrder(Long orderid) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order shippedOrder(Long orderld) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order deliveredOrder(Long orderld) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order cancledOrder(Long orderld) throws OrderException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
