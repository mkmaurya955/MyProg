package com.example.jaspersubreport.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.jaspersubreport.entity.Order;
import com.example.jaspersubreport.entity.OrderAndOrderItemDTO;
import com.example.jaspersubreport.entity.OrderItem;

@Service
public class JasperReportService {

	public List<OrderAndOrderItemDTO> getAllData() {

		List<Order> orders = new ArrayList<>();

		List<OrderItem> orderItems1 = new ArrayList<>();
		orderItems1.add(new OrderItem("Mobile", 19, 9.9));
		orderItems1.add(new OrderItem("Lp", 19, 9.9));

		List<OrderItem> orderItems2 = new ArrayList<>();
		orderItems2.add(new OrderItem("jj", 9, 9.9));
		orderItems2.add(new OrderItem("jk", 10, 9.9));
		orderItems2.add(new OrderItem("jl", 11, 9.9));
		orderItems2.add(new OrderItem("jm", 12, 9.9));

		// Create orders and add order items
		Order order1 = new Order("EL", orderItems1);
		Order order2 = new Order("AB", orderItems2);

		// Add orders to the main list
		orders.add(order1);
		orders.add(order2);

		List<OrderAndOrderItemDTO> orderAndItemDTOs = new ArrayList<>();
		for (Order order : orders) {

			String msg = null;
			for (OrderItem orderItem : order.getOrderItems()) {

				x: for (OrderAndOrderItemDTO orderAndOrderItemDTO : orderAndItemDTOs) {

					if ((orderAndOrderItemDTO==null) || (orderAndOrderItemDTO.getCustomerName().isEmpty())) {

						msg = "FALSE";

					} else if (orderAndOrderItemDTO.getCustomerName().equalsIgnoreCase(order.getCustomerName())) {

						msg = "TRUE";
						break x;

					}

				}

				OrderAndOrderItemDTO dto = new OrderAndOrderItemDTO();
				if ("TRUE".equals(msg)) {
					dto.setCustomerName("");
				} else {
					dto.setCustomerName(order.getCustomerName());
				}
				dto.setProductName(orderItem.getProductName());
				dto.setQuantity(orderItem.getQuantity());
				dto.setPrice(orderItem.getPrice());
				orderAndItemDTOs.add(dto);
			}

		}

		return orderAndItemDTOs;
	}

}
