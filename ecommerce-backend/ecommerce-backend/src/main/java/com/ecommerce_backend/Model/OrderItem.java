package com.ecommerce_backend.Model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnore
	@ManyToOne
	private Order order;
	
	@ManyToOne
	private Product product;
	
	private String size;
	
	private int quantity;
	
	private int price;
	
	private int discountedPrice;
	
	private Long userId;
	
	private LocalDateTime deliverydate;

	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public OrderItem(Long id, Order order, Product product, String size, int quantity, int price, int discountedPrice,
			Long userId, LocalDateTime deliverydate) {
		super();
		this.id = id;
		this.order = order;
		this.product = product;
		this.size = size;
		this.quantity = quantity;
		this.price = price;
		this.discountedPrice = discountedPrice;
		this.userId = userId;
		this.deliverydate = deliverydate;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(int discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public LocalDateTime getDeliverydate() {
		return deliverydate;
	}

	public void setDeliverydate(LocalDateTime deliverydate) {
		this.deliverydate = deliverydate;
	}
	
	
}
