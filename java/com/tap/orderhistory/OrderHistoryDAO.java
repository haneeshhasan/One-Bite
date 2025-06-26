package com.tap.orderhistory;

import java.util.List;

public interface OrderHistoryDAO {

    List<OrderHistory> fetchAll();

    int insert(OrderHistory orderHistory);

    OrderHistory fetchSpecific(int orderHistoryId);

    int update(OrderHistory orderHistory);

    int delete(int orderHistoryId);
}
