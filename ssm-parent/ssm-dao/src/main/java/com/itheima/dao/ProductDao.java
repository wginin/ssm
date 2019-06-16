package com.itheima.dao;

import com.itheima.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/********
 * author:shenkunlin
 * date:2018/8/24 16:04
 * description:深圳黑马
 * version:1.0
 ******/
public interface ProductDao {

    /***
     * 注解：@Select
     * 查询产品列表
     * @return
     */
    @Select("select * from product")
    List<Product> list();

    /****
     * 注解：@Insert
     *
     * 使用序列实现主键赋值：
     *      注解@SelectKey
     *              statement:指定要查询的SQl域
     *              resultType:SQL语句执行后返回结果的类型
     *              keyProperty:SQL语句执行后获取的返回结果赋值给入参指定的属性
     *              before:表示statement指定的SQl 语句执行的优先级
     *
     *
     * 增加产品数据
     * @param product
     * @return
     */

    @Insert("insert into product(id,productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)values(#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    int add(Product product);


    /***
     * 注解@Select
     * 根据ID查询产品信息
     * @param id
     * @return
     */
    @Select(value = "select * from product where id=#{id}")
    Product getById(Long id);

    /***
     * 注解@Update
     * 修改产品信息
     * @param product
     * @return
     */
    @Update("update product set productNum=#{productNum},productName=#{productName},cityName=#{cityName},departureTime=#{departureTime},productPrice=#{productPrice},productDesc=#{productDesc},productStatus=#{productStatus} where id=#{id}")
    int update(Product product);

    /****
     * @Delete
     * 删除操作
     * @param id
     * @return
     */
    @Delete(value = "delete from product where id=#{id}")
    int deleteById(Long id);

    /****
     * 查询总记录数
     * @return
     */
    @Select("select count(*) from product")
    int findCount();

    /*****
     * 基于SQl语句分页查询
     * @param start
     * @param end
     * @return
     */
    @Select("select * from (select rownum rn,p.* from product p) where rn between #{start} and #{end}")
    List<Product> pageList(@Param(value = "start")int start, @Param(value = "end")int end);
}
