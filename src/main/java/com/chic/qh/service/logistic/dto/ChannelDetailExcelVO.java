package com.chic.qh.service.logistic.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 渠道详情导出
 * 
 * @author Carney
 * @date 2023-06-04 23:22:29
 */
@Data
@ContentRowHeight(17)
@HeadRowHeight(20)
@ColumnWidth(22)
public class ChannelDetailExcelVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *   国家
	 */
	@ExcelProperty(value = "国家/地区", index = 0)
	private String country;

	/**
	 *   计抛比
	 */
	@ExcelProperty(value = "记抛比", index = 1)
	private BigDecimal volWeightRate;

	/**
	 *   物流时效
	 */
	@ExcelProperty(value = "参考时效", index = 2)
	private String shippingTime;

	/**
	 *   重量左值
	 */
	@ExcelProperty(value = "重量左值(>)", index = 3)
	private BigDecimal weightLeft;

	/**
	 *   重量右值
	 */
	@ExcelProperty(value = "重量右值(<=)", index = 4)
	private BigDecimal weightRight;

	/**
	 *   运费
	 */
	@ExcelProperty(value = "运费(RMB/KG)", index = 5)
	private BigDecimal shippingFee;

	/**
	 *   挂号费
	 */
	@ExcelProperty(value = "挂号费(RMB/票)", index = 6)
	private BigDecimal extraFee;


}
