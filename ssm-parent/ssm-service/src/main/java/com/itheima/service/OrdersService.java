package com.itheima.service;

import com.itheima.domain.Orders;

import java.util.List;

/********
 * author:shenkunlin
 * date:2018/8/24 17:52
 * description:深圳黑马
 * version:1.0
 ******/
public interface OrdersService {
    /***
     * 订单列表
     * @return
     */
    List<Orders> list();

    /****
     * 添加订单信息
     * @param orders
     * @return
     */
    int add(Orders orders);
}
