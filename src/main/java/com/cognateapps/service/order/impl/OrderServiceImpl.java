package com.cognateapps.service.order.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognateapps.dao.order.OrderDao;
import com.cognateapps.entity.order.Order;
import com.cognateapps.request.order.OrderCreateRequest;
import com.cognateapps.request.order.OrderUpdateRequest;
import com.cognateapps.service.order.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao orderDao;
	
	@Override
	public Order findOrderById(Integer orderId) {
		return orderDao.findOrderByOrderId(orderId);
	}

	@Override
	public Order saveOrder(OrderCreateRequest orderCreateRequest) {
		Order order = new Order();
		order.setOrderName(orderCreateRequest.getOrderName());
		return orderDao.save(order);
	}

	@Override
	public Order updateOrder(Integer orderId, OrderUpdateRequest orderUpdateRequest) {

		if(Objects.isNull(orderId))
			throw new IllegalArgumentException("Order id is null");
		
		Order order = orderDao.findOrderByOrderId(orderId);
		order.setOrderName(Objects.nonNull(orderUpdateRequest.getOrderName()) ? orderUpdateRequest.getOrderName() : order.getOrderName());
		return order;
	}

	@Override
	public void deleteOrder(Integer orderId) {
		if(Objects.isNull(orderId) || orderId<=0)
			throw new NullPointerException("Order id is null or invalid");
		
		Order order = orderDao.findOrderByOrderId(orderId);
		orderDao.delete(order);
	}

}
