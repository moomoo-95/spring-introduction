package moomoo.spring.basic.order.base;

import moomoo.spring.basic.order.Order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
