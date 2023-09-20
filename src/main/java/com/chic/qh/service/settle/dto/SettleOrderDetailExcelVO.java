package com.chic.qh.service.settle.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.alibaba.excel.metadata.data.WriteCellData;
import lombok.Data;

import javax.annotation.Generated;
import java.io.Serializable;
import java.math.BigDecimal;
import java.net.URL;

/**
 * 结算单明细导出
 * 
 * @author Carney
 * @date 2023-06-12 23:22:29
 */
@Data
@ContentRowHeight(80)
@HeadRowHeight(20)
@ColumnWidth(22)
public class SettleOrderDetailExcelVO implements Serializable {
	private static final long serialVersionUID = 1L;

	@ExcelProperty(value = "settleOrderSn", index = 0)
	private String settleOrderSn;

	/**
	 *   订单SN
	 */
	@ExcelProperty(value = "orderSn", index = 1)
	private String orderSn;

	/**
	 *   商品数量
	 */
	@ExcelProperty(value = "quantity", index = 2)
	private Integer quantity;

	/**
	 *   店小蜜SKU
	 */
	@ExcelProperty(value = "dxmSku", index = 3)
	private String sku;

	/**
	 *   skuId
	 */
	@ExcelProperty(value = "skuId", index = 4)
	private Integer skuId;

	/**
	 *   金额
	 */
	@ExcelProperty(value = "amount", index = 5)
	private BigDecimal amount;

	/**
	 *   创建时间
	 */
	@ExcelProperty(value = "gmtCreated", index = 6)
	private String gmtCreatedStr;


}
