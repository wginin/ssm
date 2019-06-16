package com.itheima.controller;

import com.itheima.domain.Orders;
import com.itheima.domain.Product;
import com.itheima.service.OrdersService;
import com.itheima.service.ProductService;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/********
 * author:shenkunlin
 * date:2018/8/24 17:50
 * description:深圳黑马
 * version:1.0
 ******/
@Controller
@RequestMapping(value = "/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private ProductService productService;


    /***
     * 添加订单信息
     * @param orders
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(Orders orders){
        //调用Service实现增加
        int acount = ordersService.add(orders);

        //跳转到list集合页面显示
        return "redirect:/orders/list";
    }


    /***
     * 增加订单页面跳转
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(Model model){
        //查询所有产品信息
        List<Product> products = productService.list();

        //存到model
        model.addAttribute("products",products);

        //跳转页面回显
        return "order-add";
    }

    /***
     * 订单列表
     * @return
     */
    @RequestMapping(value = "/list")
    public String list(Model model){
        //调用Service实现查询
        List<Orders> orders = ordersService.list();

        //将结果集保存到Model
        model.addAttribute("orders",orders);

        //页面跳转
        return "order-list";
    }

}
