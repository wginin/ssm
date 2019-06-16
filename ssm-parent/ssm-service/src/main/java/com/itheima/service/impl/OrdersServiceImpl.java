package com.itheima.service.impl;

import com.itheima.dao.OrdersDao;
import com.itheima.domain.Orders;
import com.itheima.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/********
 * author:shenkunlin
 * date:2018/8/24 17:53
 * description:深圳黑马
 * version:1.0
 ******/
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    @Override
    public List<Orders> list() {
        return ordersDao.list();
    }

    @Override
    public int add(Orders orders) {
        return ordersDao.add(orders);
    }
}
