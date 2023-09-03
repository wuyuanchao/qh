package com.chic.qh.service.goods.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.alibaba.excel.metadata.data.WriteCellData;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.net.URL;

/**
 * Sku导出
 * 
 * @author Carney
 * @date 2023-06-12 23:22:29
 */
@Data
@ContentRowHeight(80)
@HeadRowHeight(20)
@ColumnWidth(22)
public class SkuListExcelVO implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *   skuId
	 */
	@ExcelProperty(value = "skuId", index = 0)
	private Integer skuId;

	/**
	 *   sku名称
	 */
	@ExcelProperty(value = "sku名称", index = 1)
	private String skuName;

	/**
	 *   sku英文名称
	 */
	@ExcelProperty(value = "sku英文名称", index = 2)
	private String skuNameEn;

	/**
	 *   图片
	 */
	@ExcelProperty(value = "图片", index = 3)
	private URL url;

	/**
	 *   供方skuId
	 */
	@ExcelProperty(value = "供方skuId", index = 4)
	private String suppSkuId;

	/**
	 *   供应商信息
	 */
	@ExcelProperty(value = "供应商信息", index = 5)
	private WriteCellData<String> suppInfo;

	/**
	 *   计费体积(长*宽*高)
	 */
	@ColumnWidth(30)
	@ExcelProperty(value = "计费体积(长*宽*高)", index = 6)
	private String volume;

	/**
	 *   计费重量(kg)
	 */
	@ExcelProperty(value = "计费重量(kg)", index = 7)
	private BigDecimal weight;

	/**
	 *   采购价(元)
	 */
	@ExcelProperty(value = "采购价(元)", index = 8)
	private BigDecimal purPrice;

	/**
	 *   店小蜜sku
	 */
	@ExcelProperty(value = "店小蜜sku", index = 9)
	private String dxmSkuId;


}
