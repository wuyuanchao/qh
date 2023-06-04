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
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(15)
public class ChannelDetailExcelVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *   国家
	 */
	@ExcelProperty(value = "country", index = 0)
	private String country;

	/**
	 *   物流时效
	 */
	@ExcelProperty(value = "shippingTime", index = 1)
	private String shippingTime;

	/**
	 *   计抛比
	 */
	@ExcelProperty(value = "volWeightRate", index = 2)
	private BigDecimal volWeightRate;

	/**
	 *   重量左值
	 */
	@ExcelProperty(value = "weightLeft", index = 3)
	private BigDecimal weightLeft;

	/**
	 *   重量右值
	 */
	@ExcelProperty(value = "weightRight", index = 4)
	private BigDecimal weightRight;

	/**
	 *   运费
	 */
	@ExcelProperty(value = "shippingFee", index = 5)
	private BigDecimal shippingFee;

	/**
	 *   挂号费
	 */
	@ExcelProperty(value = "extraFee", index = 6)
	private BigDecimal extraFee;


}
