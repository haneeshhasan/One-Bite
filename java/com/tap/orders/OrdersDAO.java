package com.tap.orders;

import java.util.List;

public interface OrdersDAO {
    List<Orders> fetchAll();

    int insert(Orders order);

    Orders fetchSpecific(int orderId);

    int update(Orders order);

    int delete(int orderId);
}
