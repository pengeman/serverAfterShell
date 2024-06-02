package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.Gson;
import com.ruoyi.common.utils.DateUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AfterSalesMapper;
import com.ruoyi.system.domain.AfterSales;
import com.ruoyi.system.service.IAfterSalesService;
import com.ruoyi.common.core.text.Convert;
import org.json.JSONArray;

/**
 * AfterSalesService业务层处理
 * 
 * @author ruoyi
 * @date 2024-05-11
 */
@Service
public class AfterSalesServiceImpl implements IAfterSalesService 
{
    @Autowired
    private AfterSalesMapper afterSalesMapper;

    /**
     * 查询AfterSales
     * 
     * @param id AfterSales主键
     * @return AfterSales
     */
    @Override
    public AfterSales selectAfterSalesById(Long id)
    {
        return afterSalesMapper.selectAfterSalesById(id);
    }

    /**
     * 查询AfterSales列表
     * 
     * @param afterSales AfterSales
     * @return AfterSales
     */
    @Override
    public List<AfterSales> selectAfterSalesList(AfterSales afterSales)
    {
        return afterSalesMapper.selectAfterSalesList(afterSales);
    }

    /**
     * 新增AfterSales
     * 
     * @param afterSales AfterSales
     * @return 结果
     */
    @Override
    public int insertAfterSales(AfterSales afterSales)
    {
        afterSales.setCreateTime(DateUtils.getNowDate());
        return afterSalesMapper.insertAfterSales(afterSales);
    }

    /**
     * 修改AfterSales
     * 
     * @param afterSales AfterSales
     * @return 结果
     */
    @Override
    public int updateAfterSales(AfterSales afterSales)
    {
        return afterSalesMapper.updateAfterSales(afterSales);
    }

    /**
     * 批量删除AfterSales
     * 
     * @param ids 需要删除的AfterSales主键
     * @return 结果
     */
    @Override
    public int deleteAfterSalesByIds(String ids)
    {
        return afterSalesMapper.deleteAfterSalesByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除AfterSales信息
     * 
     * @param id AfterSales主键
     * @return 结果
     */
    @Override
    public int deleteAfterSalesById(Long id)
    {
        return afterSalesMapper.deleteAfterSalesById(id);
    }

    @Override
    public int importAfterSalesFromJson(String afterSalesJson) {
        //System.out.println("importAfterSalesFromJson  : " + afterSalesJson);
        org.json.JSONArray jsonArray = new JSONArray(afterSalesJson);
        jsonArray.forEach(item -> {
            org.json.JSONObject jso = (org.json.JSONObject) item;
            System.out.println("importAfterSalesFromJson  : " + jso.toString());
            System.out.println("importAfterSalesFromJson  : " + jso.get("消息内容"));
            String id = (String) jso.get("id");
            String msg = (String) jso.get("消息内容");
            String msgRelate = (String) jso.get("关联数据");
            String person = (String) jso.get("提交人");
            String time = (String) jso.get("创建时间");
            String state = (String) jso.get("状态");
            String customer = (String) jso.get("售后服务客户名称");
            String depart = (String) jso.get("所属部门");
            String master = (String) jso.get("负责人");
            String attachment = (String) jso.get("附件");
            String remark = (String) jso.get("备注");
            System.out.println("消息内容");
            System.out.println(msg);
        });
               return 1;
    }
}
