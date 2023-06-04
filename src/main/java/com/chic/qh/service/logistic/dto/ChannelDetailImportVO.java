package com.chic.qh.service.logistic.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 渠道详情导入
 * 
 * @author Carney
 * @date 2023-06-04 23:22:29
 */
@Data
public class ChannelDetailImportVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *   国家
	 */
	private String country;

	/**
	 *   物流时效
	 */
	private String shippingTime;

	/**
	 *   计抛比
	 */
	private BigDecimal volWeightRate;

	/**
	 *   重量左值
	 */
	private BigDecimal weightLeft;

	/**
	 *   重量右值
	 */
	private BigDecimal weightRight;

	/**
	 *   运费
	 */
	private BigDecimal shippingFee;

	/**
	 *   挂号费
	 */
	private BigDecimal extraFee;


}
