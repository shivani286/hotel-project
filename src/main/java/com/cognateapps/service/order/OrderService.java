package com.cognateapps.service.order;

import com.cognateapps.entity.order.Order;
import com.cognateapps.request.order.OrderCreateRequest;
import com.cognateapps.request.order.OrderUpdateRequest;

public interface OrderService {

	Order findOrderById(Integer orderId);

	Order saveOrder(OrderCreateRequest orderCreateRequest);

	Order updateOrder(Integer orderId, OrderUpdateRequest orderUpdateRequest);

	void deleteOrder(Integer orderId);

}
