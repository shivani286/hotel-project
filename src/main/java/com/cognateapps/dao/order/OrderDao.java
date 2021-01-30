package com.cognateapps.dao.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognateapps.entity.order.Order;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {

	Order findOrderByOrderId(Integer orderId);

}
