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
    @ExcelProperty(index = 0, value = "Order Number")
    private String orderSn;

    /**
     *   物流单号
     */
    @ExcelProperty(index = 1, value = "Tracking")
    private String trackingNumber;

    /**
     *   商品数量
     */
    @ExcelProperty(index = 2, value = "Quantity")
    private Integer quantity;

    /**
     *   价格
     */
    @ExcelProperty(index = 3, value = "Price")
    private BigDecimal price;

    /**
     *   sku
     */
    @ExcelProperty(index = 4, value = "DXM SKU")
    private String dxmSku;

    /**
     *   product
     */
    @ExcelProperty(index = 5, value = "DXM Product Code")
    private String dxmProductCode;

    /**
     *   sku
     */
    @ExcelProperty(index = 6, value = "SKU")
    private String sku;

    /**
     *   收件人
     */
    @ExcelProperty(index = 7, value = "Shipping name")
    private String shippingName;

    /**
     *   详细地址
     */
    @ExcelProperty(index = 8, value = "Address")
    private String address;

    /**
     *   市
     */
    @ExcelProperty(index = 9, value = "City")
    private String city;

    /**
     *   邮编
     */
    @ExcelProperty(index = 10, value = "Zip code")
    private String zipCode;

    /**
     *   省
     */
    @ExcelProperty(index = 11, value = "Province")
    private String province;

    /**
     *   国家
     */
    @ExcelProperty(index = 12, value = "Country")
    private String country;

    /**
     *   国家码
     */
    @ExcelProperty(index = 13, value = "Country code")
    private String countryCode;

    /**
     *   手机号
     */
    @ExcelProperty(index = 14, value = "Phone number")
    private String phoneNumber;

    /**
     *   支付时间
     */
    @ExcelProperty(index = 15, value = "Payment time", converter = ExcelDate2TimestampConverter.class)
    private Integer payTime;

    /**
     *   商品ID
     */
    @ExcelProperty(index = 16, value = "Products ID")
    private String productId;

    /**
     *   下单时间
     */
    @ExcelProperty(index = 17, value = "下单时间", converter = ExcelDate2TimestampConverter.class)
    private Integer orderTime;


    /**
     *   发货时间
     */
    @ExcelProperty(index = 18, value = "发货时间", converter = ExcelDate2TimestampConverter.class)
    private Integer shippingTime;

    /**
     *   发货方式
     */
    @ExcelProperty(index = 19, value = "物流方式")
    private String shippingMethod;

}
