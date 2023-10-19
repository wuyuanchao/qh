package com.chic.qh.support.utils;

import java.sql.Date;
import java.time.LocalDate;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

/**
 * @Description:
 * @author: xumingwei
 * @date: 2023—08—17 18:09
 */
public class ExcelDate2TimestampConverter implements Converter<Integer> {

    @Override
    public Class<?> supportJavaTypeKey() {
        return Integer.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public Integer convertToJavaData(ReadCellData<?> cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        if(cellData.getType().equals(CellDataTypeEnum.NUMBER)){
            LocalDate localDate = LocalDate.of(1900, 1, 1).plusDays(cellData.getNumberValue().longValue() - 2);
            Long time = Date.valueOf(localDate).getTime() / 1000;
            return time.intValue();
        }
        if(cellData.getType().equals(CellDataTypeEnum.STRING)){
            String stringValue = cellData.getStringValue();
            return Long.valueOf(DateUtils.dateToUnixTimestamp(stringValue, DateUtils.DATE_FULL_STR) / 1000).intValue();
        }
        return null;
    }
}
