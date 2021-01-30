package com.cognateapps.controller.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognateapps.entity.order.Order;
import com.cognateapps.request.order.OrderCreateRequest;
import com.cognateapps.request.order.OrderUpdateRequest;
import com.cognateapps.service.order.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("order")
@Slf4j
@Api(tags = "Order Service")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	
	@GetMapping("/{orderId}")
	@ApiOperation(value = "${OrderController.getorder}")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Conversion"),
            @ApiResponse(code = 401, message = "You are not authorized to send message"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
	
    public Order getOrderById(@PathVariable Integer orderId) {
        return orderService.findOrderById(orderId);
    }
	
	@PostMapping("/create")
	public Order createOrder(@RequestBody OrderCreateRequest orderCreateRequest) {
		return orderService.saveOrder(orderCreateRequest);
	}

	/**
	 * update existing Order
	 * @param id
	 * @param Order
	 * @return
	 */
	@PutMapping("update/{orderId}")
	public Order updateOrder(@PathVariable("orderId")Integer orderId, @RequestBody OrderUpdateRequest orderUpdateRequest) {
		System.out.println("orderID"+orderId+"uadet Order requset==>"+orderUpdateRequest);
		return orderService.updateOrder(orderId,orderUpdateRequest);
	}
	
	/**
	 * delete Order(update Order (permanent delete))
	 * @param id
	 */
	@DeleteMapping("delete/{orderId}")
	public void deleteorder(@PathVariable("orderId") Integer orderId) {
		orderService.deleteOrder(orderId);
	}
	
}
