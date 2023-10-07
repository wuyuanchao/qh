package com.chic.qh.service.goods.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class SkuImportDTO {
    @ExcelProperty(index = 1)
    private String skuName;
    @ExcelProperty(index = 3)
    private String dxmSkuId;
    @ExcelProperty(index = 4)
    private Integer parentId;
}
