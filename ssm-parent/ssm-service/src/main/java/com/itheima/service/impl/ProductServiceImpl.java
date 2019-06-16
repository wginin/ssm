package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.ProductDao;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import com.itheima.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/********
 * author:shenkunlin
 * date:2018/8/24 16:02
 * description:深圳黑马
 * version:1.0
 ******/
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> list() {
        //调用Dao查询
        return productDao.list();
    }

    @Override
    public int add(Product product) {
        return productDao.add(product);
    }

    @Override
    public Product getById(Long id) {
        return productDao.getById(id);
    }

    @Override
    public int update(Product product) {
        return productDao.update(product);
    }

    @Override
    public int deleteById(Long id) {
        return productDao.deleteById(id);
    }

    /****
     * 分页实现
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageBean<Product> pageList(int page, int size) {
        PageBean<Product> pageInfo = new PageBean<Product>();

        //查询总记录数
        int count = productDao.findCount();
        pageInfo.setTotalCount(count);

        //查询结果集对象
        int start = (page-1)*size+1;
        int end = page*size;
        List<Product> products = productDao.pageList(start,end);

        pageInfo.setBeanList(products);
        pageInfo.setPageCode(page);
        return pageInfo;
    }

    /****
     * 分页操作
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Product> pageHelperList(int page, int size) {
        //PageHeleper.startPage(page,size);
        PageHelper.startPage(page,size);

        //查询结果集[不带分页]
        List<Product> products = productDao.list();

        //分装一个PageInfo
        PageInfo<Product> pageInfo = new PageInfo<Product>(products);
        return pageInfo;
    }
}
