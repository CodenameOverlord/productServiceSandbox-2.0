package com.ver.Order_service.service;

import com.ver.Order_service.dtos.OrderLineItemsDto;
import com.ver.Order_service.dtos.OrderRequest;
import com.ver.Order_service.model.Order;
import com.ver.Order_service.model.OrderLineItems;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {
    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setOrderLineItemsList(orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(
                this::toOrderLineDto
        ).toList());

    }

    private OrderLineItems toOrderLineDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItems.getQuantity());
        orderLineItems.setSkuCode(orderLineItems.getSkuCode());
        return orderLineItems;
    }
}
