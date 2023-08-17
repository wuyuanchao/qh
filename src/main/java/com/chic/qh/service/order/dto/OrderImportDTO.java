package com.chic.qh.service.order.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.chic.qh.support.utils.ExcelDate2TimestampConverter;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class OrderImportDTO implements Serializable {

    private static final long serialVersionUID = -1434883568535799649L;

    /**
     *   订单编号
     */
    @ExcelProperty(value = "Order Number")
    private String orderSn;

    /**
     *   物流单号
     */
    @ExcelProperty(value = "Tracking number")
    private String trackingNumber;

    /**
     *   物流单号2
     */
    @ExcelProperty(value = "Tracking number 2")
    private String trackingNumber2;

    /**
     *   商品数量
     */
    @ExcelProperty(value = "Quantity")
    private Integer quantity;

    /**
     *   价格
     */
    @ExcelProperty(value = "Price")
    private BigDecimal price;

    /**
     *   sku
     */
    @ExcelProperty(value = "SKU")
    private String sku;

    /**
     *   商品ID
     */
    @ExcelProperty(value = "Products ID")
    private Integer productId;

    /**
     *   国家
     */
    @ExcelProperty(value = "Country")
    private String country;

    /**
     *   国家码
     */
    @ExcelProperty(value = "国家二字码")
    private String countryCode;

    /**
     *   省
     */
    @ExcelProperty(value = "Province")
    private String province;

    /**
     *   市
     */
    @ExcelProperty(value = "City")
    private String city;

    /**
     *   详细地址
     */
    @ExcelProperty(value = "Address")
    private String address;

    /**
     *   邮编
     */
    @ExcelProperty(value = "Zip code")
    private String zipCode;

    /**
     *   收件人
     */
    @ExcelProperty(value = "Shipping name")
    private String shippingName;

    /**
     *   手机号
     */
    @ExcelProperty(value = "Phone number")
    private String phoneNumber;

    /**
     *   下单时间
     */
    @ExcelProperty(value = "下单时间", converter = ExcelDate2TimestampConverter.class)
    private Integer orderTime;

    /**
     *   支付时间
     */
    @ExcelProperty(value = "Payment time", converter = ExcelDate2TimestampConverter.class)
    private Integer payTime;

    /**
     *   发货时间
     */
    @ExcelProperty(value = "发货时间", converter = ExcelDate2TimestampConverter.class)
    private Integer shippingTime;

    /**
     *   发货方式
     */
    @ExcelProperty(value = "物流方式")
    private String shippingMethod;
}
