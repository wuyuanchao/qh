package com.chic.qh.support.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Data
@Slf4j
public class NoModelDataListener extends AnalysisEventListener<Object> {
    List<Object> list = new ArrayList<>();

    @Override
    public void invoke(Object data, AnalysisContext context) {
        list.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
    }
}
