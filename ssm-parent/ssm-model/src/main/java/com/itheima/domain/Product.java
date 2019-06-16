package com.itheima.domain;

import com.itheima.util.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/********
 * author:shenkunlin
 * date:2018/8/24 15:11
 * description:深圳黑马
 * version:1.0
 ******/
public class Product {

    private Long id;
    private String productNum;
    private String productName;
    private String cityName;
    /*
    * Spring包  spring-context
    * */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date departureTime;
    private Float productPrice;
    private String productDesc;
    private Integer productStatus;

    /****
     * Date类型转String
     * 如果当前Product对象存入到了Request域中，则再页面可以直接调用对应get方法
     *          规则：
     *              1)去掉get
     *                    DepartureTimeStr
     *              2)将剩下的首字母小写
     *                   departureTimeStr
     *
     * @return
     */
    public String getDepartureTimeStr(){
        if(departureTime==null){
            return "";
        }
        //转换
        return DateUtil.date2str(departureTime, DateUtil.simpleDateFormat4);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }
}
