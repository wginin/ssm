package com.itheima.dao;

import com.itheima.domain.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

/********
 * author:shenkunlin
 * date:2018/8/24 17:54
 * description:深圳黑马
 * version:1.0
 ******/
public interface OrdersDao {

    /***
     * 列表查询
     * @return
     */
    @Results(value = {
        @Result(property = "product.id",column = "pid"),
        @Result(property = "product.productNum",column = "productNum"),
        @Result(property = "product.productName",column = "productName"),
        @Result(property = "product.cityName",column = "cityName"),
        @Result(property = "product.departureTime",column = "departureTime"),
        @Result(property = "product.productPrice",column = "productPrice"),
        @Result(property = "product.productDesc",column = "productDesc"),
        @Result(property = "product.productStatus",column = "productStatus")
    })
    @Select("select o.*,p.id pid,p.productNum,p.productName,p.cityName,p.departureTime,p.productPrice,p.productDesc,p.productStatus from product p,orders o where o.productid=p.id")
    List<Orders> list();

    /****
     * 主键没值，查询序列
     * @SelectKey
     * @Insert
     * @param orders
     * @return
     */

    @Insert(value = "insert into orders(id,orderNum,orderTime,peopleCount,orderDesc,payType,orderStatus,productId)values(#{id},#{orderNum},#{orderTime},#{peopleCount},#{orderDesc},#{payType},#{orderStatus},#{product.id})")
    int add(Orders orders);

}
