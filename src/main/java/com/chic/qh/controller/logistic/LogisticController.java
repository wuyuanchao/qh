package com.chic.qh.controller.logistic;

import com.chic.qh.repository.model.LogisticChannel;
import com.chic.qh.service.logistic.LogisticService;
import com.chic.qh.service.logistic.dto.ChannelDetailExcelVO;
import com.chic.qh.service.logistic.dto.LogisticConfigDTO;
import com.chic.qh.support.utils.ExcelUtils;
import com.chic.qh.support.web.RespWrap;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("logistic")
public class LogisticController {

    @Autowired
    private LogisticService logisticService;

    @RespWrap
    @GetMapping("getChannelList")
    public PageInfo<LogisticChannel> getChannelList(@RequestParam(defaultValue = "1", name = "current") Integer pageNum,
                                                    @RequestParam(defaultValue = "20") Integer pageSize,
                                                    @RequestParam(required = false) String company,
                                                    @RequestParam(required = false) String code) {
        return logisticService.getChannelList(company, code, pageNum, pageSize);
    }

    @RespWrap
    @GetMapping("channel/{channelCode}")
    public LogisticChannel getChannel(@PathVariable("channelCode") String channelCode) {
        return logisticService.getChannelInfo(channelCode);
    }

    @RespWrap
    @PostMapping("addChannel")
    public void addChannel(@RequestBody LogisticChannel logisticChannel) {
        logisticService.addChannel(logisticChannel);
    }

    @RespWrap
    @DeleteMapping("deleteChannel/{channelId}")
    public int deleteChannel(@PathVariable("channelId") Integer channelId) {
        return logisticService.deleteChannel(channelId);
    }

    @RespWrap
    @PutMapping("updateChannel")
    public int updateChannel(@RequestBody LogisticChannel logisticChannel) {
        return logisticService.updateChannel(logisticChannel);
    }

    @RespWrap
    @GetMapping("getChannelDetail/{channelCode}")
    public List<LogisticConfigDTO> getChannelDetail(@PathVariable("channelCode") String channelCode){
        return logisticService.getChannelDetail(channelCode);
    }

    /**
     * 渠道详情导入
     * @param channelId
     * @param file
     */
    @PostMapping("importChannelDetail/{channelId}")
    public void importChannelDetail(@PathVariable("channelId") Integer channelId, @RequestParam("file") MultipartFile file) {
        List<ChannelDetailExcelVO> dataList = ExcelUtils.importExcel(file, ChannelDetailExcelVO.class, null);
        logisticService.processImportChannelDetail(channelId, dataList);
    }

    /**
     * 渠道详情导出
     * @param channelId
     * @param response
     */
    @PostMapping("exportChannelDetail/{channelId}")
    public void exportChannelDetail(@PathVariable("channelId") Integer channelId, HttpServletResponse response) {
        //查询渠道详情列表
        List<ChannelDetailExcelVO> channelDetailExportVOList = logisticService.exportChannelDetail(channelId);
        //导出渠道详情
        String fileName = "ChannelDetailExport";
        ExcelUtils.exportExcel(channelDetailExportVOList, ChannelDetailExcelVO.class, fileName, response);
    }
}
