package com.chic.qh.support.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Excel导出
 *
 *
 */
@Slf4j
public class ExcelUtils {

    private static final String DEFAULT_SHEET_NAME = "Sheet1";

    /**
     * 导入
     * @param file
     * @param dataClass
     * @param sheetName
     * @return
     * @param <T>
     */
    public static <T> List<T> importExcel(MultipartFile file, Class<T> dataClass, String sheetName) {
        try {
            if (StringUtils.isBlank(sheetName)) {
                sheetName = DEFAULT_SHEET_NAME;
            }
            // 实例化实现了AnalysisEventListener接口的类
            NoModelDataListener listener = new NoModelDataListener();
            InputStream io = file.getInputStream();
            EasyExcel.read(io, dataClass , listener).sheet().sheetName(sheetName).doRead();
            // 获取数据
            return listener.getList().stream().map(x-> JSONObject.parseObject(JSONObject.toJSONString(x), dataClass)).collect(Collectors.toList());
        } catch (IOException e) {
           throw new RuntimeException("Excel解析异常");
        }
    }

    public static boolean checkObjAllFieldsIsNull(Object object) {
        if (null == object) {
            return true;
        }
        try {
            for (Field field : object.getClass().getDeclaredFields()) {
                if (!Objects.equals("serialVersionUID", field.getName()) && !Objects.equals("$jacocoData", field.getName())) {
                    ReflectionUtils.makeAccessible(field);
                    if (field.get(object) != null && StringUtils.isNotBlank(field.get(object).toString())) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            log.error("判断字段属性为空异常", e);
        }
        return true;
    }

    /**
     * 导出
     * @param exportList
     * @param dataClass
     * @param fileName
     * @param response
     */
    public static void exportExcel(List<?> exportList, Class dataClass, String fileName, HttpServletResponse response) {
        try {
            //设置响应头
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setCharacterEncoding("utf-8");
            fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
            response.addHeader("Cache-Control", "no-cache");

            //导出excel
            EasyExcel.write(response.getOutputStream(), dataClass)
                    .sheet(fileName)
                    .doWrite(exportList);
        }catch (Exception e){
            log.error("导出excel异常！fileName:{}", fileName, e);
        }
    }
}