package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Product;
import com.itheima.util.PageBean;

import java.util.List;

/********
 * author:shenkunlin
 * date:2018/8/24 16:02
 * description:深圳黑马
 * version:1.0
 ******/
public interface ProductService {
    /***
     * 集合查询
     * @return
     */
    List<Product> list();

    /****
     * 添加产品数据
     * @param product
     * @return
     */
    int add(Product product);

    /***
     * 根据ID查询
     * @param id
     * @return
     */
    Product getById(Long id);

    /***
     * 修改产品信息
     * @param product
     * @return
     */
    int update(Product product);

    /***
     * 根据ID删除
     * @param id
     * @return
     */
    int deleteById(Long id);

    /****
     * 根据SQL语句实现分页查询
     * @param page
     * @param size
     * @return
     */
    PageBean<Product> pageList(int page, int size);

    /***
     * 使用分页插件实现分页操作
     * @param page
     * @param size
     * @return
     */
    PageInfo<Product> pageHelperList(int page, int size);
}
