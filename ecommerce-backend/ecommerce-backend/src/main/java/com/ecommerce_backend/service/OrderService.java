package com.ecommerce_backend.service;

import java.util.List;

import com.ecommerce_backend.Model.Address;
import com.ecommerce_backend.Model.Order;
import com.ecommerce_backend.Model.User;
import com.ecommerce_backend.exception.OrderException;

public interface OrderService {

	public Order createOrder(User user, Address shippingAdress);

	public Order findOrderById(Long orderld) throws OrderException;

	public List<Order> usersOrderHistory(Long userld);

	public Order placedOrder(Long orderld) throws OrderException;

	public Order confirmedOrder(Long orderid)throws OrderException;

	public Order shippedOrder(Long orderld) throws OrderException;

	public Order deliveredOrder(Long orderld) throws OrderException;

	public Order cancledOrder(Long orderld) throws OrderException;
}
