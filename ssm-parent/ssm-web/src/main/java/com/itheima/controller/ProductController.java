package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import com.itheima.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/********
 * author:shenkunlin
 * date:2018/8/24 15:59
 * description:深圳黑马
 * version:1.0
 ******/
@Controller
@RequestMapping(value="/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    /***
     * 根据ID删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/del")
    public String deleteById(Long id){
        //调用Service实现删除
        int dcount = productService.deleteById(id);

        //返回到列表页
        return "redirect:/product/list";
    }


    /***
     * 修改产品
     * @param product
     * @return
     */
    @RequestMapping(value = "/update")
    public String update(Product product){
        //调用Service实现修改
        int mcount = productService.update(product);

        //返回到列表查询
        return "redirect:/product/list";
    }


    /***
     * 根据ID查询
     * @param id
     * @return
     */
    @RequestMapping(value = "/one")
    public String getById(Long id,Model model){
        //根据ID查询
        Product product = productService.getById(id);

        //将数据存入到model中
        model.addAttribute("product",product);

        //跳转修改页面
        return "product-update";
    }



    /***
     * 保存产品信息
     * @param product
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(Product product){
        //调用Service实现增加
        int acount = productService.add(product);

        //增加完成之后，跳转列表查询
        return "redirect:/product/list";
    }

    /**
     *  使用PageHelper实现分页
     *  分页查询
     *  /product/list
     * @return
     */
    @RequestMapping(value = "/list")
    public String list(@RequestParam(value = "page",required = false,defaultValue = "1")int page,
                       @RequestParam(value = "size",required = false,defaultValue = "5")int size,Model model){
        //调用service实现查询获取结果集
        PageInfo<Product> pageInfo = productService.pageHelperList(page,size);

        //将结果集存入到Model
        model.addAttribute("pageInfo",pageInfo);

        //跳转页面
        return "product-list";
    }

    /**
     *  分页查询
     *  /product/list
     * @return
     */
    @RequestMapping(value = "/listoracle")
    public String listoracle(@RequestParam(value = "page",required = false,defaultValue = "1")int page,
                       @RequestParam(value = "size",required = false,defaultValue = "5")int size,Model model){
        //调用service实现查询获取结果集
        PageBean<Product> pageInfo = productService.pageList(page,size);

        //将结果集存入到Model
        model.addAttribute("pageInfo",pageInfo);

        //跳转页面
        return "product-list";
    }


    /**
     *  /product/list
     * @return
     */
    @RequestMapping(value = "/listall")
    public String listall(Model model){
        //调用service实现查询获取结果集
        List<Product> products = productService.list();

        //将结果集存入到Model
        model.addAttribute("products",products);

        //跳转页面
        return "product-list";
    }
}
