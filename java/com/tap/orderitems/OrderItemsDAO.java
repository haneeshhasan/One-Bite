package com.tap.orderitems;

import java.util.List;

public interface OrderItemsDAO {

    List<OrderItems> fetchAll();

    int insert(OrderItems orderItems);

    OrderItems fetchSpecific(int orderItemsId);

    int update(OrderItems orderItems);

    int delete(int orderItemsId);
}
