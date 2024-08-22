package com.ruoyi.system.service.impl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.system.domain.AftersalesBack;
import com.ruoyi.system.domain.Note;
import com.ruoyi.system.domain.SysFileInfo;
import com.ruoyi.system.mapper.AftersalesBackMapper;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AfterSalesMapper;
import com.ruoyi.system.domain.AfterSales;
import com.ruoyi.system.service.IAfterSalesService;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.biz.AfterSalesBiz;

/**
 * afterSalesService业务层处理
 *
 * @author peng
 * @date 2024-07-04
 */
@Service
public class AfterSalesServiceImpl implements IAfterSalesService {
    @Autowired
    private AfterSalesMapper afterSalesMapper;
    @Autowired
    private AftersalesBackMapper aftersalesBackMapper;
@Autowired
private SysFileInfoServiceImpl sysFileInfoService;
    /**
     * 查询afterSales
     *
     * @param id afterSales主键
     * @return afterSales
     */
    @Override
    public AfterSales selectAfterSalesById(Long id) {
        return afterSalesMapper.selectAfterSalesById(id);
    }

    /**
     * 查询afterSales列表
     *
     * @param afterSales afterSales
     * @return afterSales
     */
    @Override
    public List<AfterSales> selectAfterSalesList(AfterSales afterSales) {
        return afterSalesMapper.selectAfterSalesList(afterSales);
    }

    /**
     * 新增afterSales
     *
     * @param afterSales afterSales
     * @return 结果
     */
    @Override
    public int insertAfterSales(AfterSales afterSales) {
        AfterSalesBiz afterSalesBiz = new AfterSalesBiz();
        afterSales.setCreateTime(DateUtils.getNowDate());
        /* 根据出厂编号，找到设备的id */
        String productionID = afterSales.getProductionID();
        long devicdId = afterSalesBiz.findTheDeviceId(productionID);
        afterSales.setDeviceid(devicdId);
        return afterSalesMapper.insertAfterSales(afterSales);
    }

    /**
     * 修改afterSales
     *
     * @param afterSales afterSales
     * @return 结果
     */
    @Override
    public int updateAfterSales(AfterSales afterSales) {
        return afterSalesMapper.updateAfterSales(afterSales);
    }

    /**
     * 批量删除afterSales
     *
     * @param ids 需要删除的afterSales主键
     * @return 结果
     */
    @Override
    public int deleteAfterSalesByIds(String ids) {
        return afterSalesMapper.deleteAfterSalesByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除afterSales信息
     *
     * @param id afterSales主键
     * @return 结果
     */
    @Override
    public int deleteAfterSalesById(Long id) {
        return afterSalesMapper.deleteAfterSalesById(id);
    }

    /**
     * 将售后单数据(afterSales)复制到售后单完成(gopassAfterSales)表中
     * 接受的参数：afterSales实体，通过单文件名
     *
     * @param afterSales
     * @return
     */
    public int gopassSales(AfterSales afterSales, String gopassFileName) {
        //System.out.println("gopassSales++++++++++++++++++++++++++++++++" + afterSales.getId());
        this.backAfterSales(afterSales);
        this.deleAfterSales(afterSales);
        return 0;
    }

    @Override
    public int importAfterSalesFromJson(String afterSalesJson) {
        //System.out.println("importAfterSalesFromJson  : " + afterSalesJson);
        try {


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

                AfterSales afterSales = new AfterSales(); // entity
                afterSales.setDeviceid(0L);
                afterSales.setFormDate(time);
                afterSales.setSalesman(person);
                afterSales.setCustomer(customer);
                afterSales.setCustomerAddr("customer add");
                afterSales.setQuality("0 质保内");
                afterSales.setConnection("联系人");
                afterSales.setTel("联系人电话");
                afterSales.setQuetion("问题描述");
                afterSales.setProductionDate("出厂日期");
                afterSales.setProductionID("出厂编号");
                afterSales.setCondition("工况");
                afterSales.setDeviceType("设备型号");
                afterSales.setTexture("材质");
                afterSales.setArea("换热面积");
                afterSales.setAmount("amount");
                afterSales.setFormType("单据类型返厂外派");
                //afterSales.setModifyTime(new SimpleDateFormat("yyyy/MM/dd").format(new Date()));
                afterSales.setModifyTime(new Date());
                this.insertAfterSales(afterSales);
            });
        } catch (Exception e) {
            System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
            e.printStackTrace();
        }
        return 1;
    }

    @Deprecated
    @Override
    public int gopassAfterSales(Long afterSalesID, AftersalesBack aftersalesBack) {
        // 复制afterSales数据到aftersalesBack
        AfterSales afterSales = this.selectAfterSalesById(afterSalesID);
        int r1 = this.backAfterSales(afterSales);
        int r2 = this.deleAfterSales(afterSales);
        return r1 & r2;
    }


    @Override
    public int backAfterSales(AfterSales afterSales) {
        AftersalesBack a2 = new AftersalesBack();

        a2.setAmount(afterSales.getAmount());
        a2.setArea(afterSales.getArea());
        a2.setCondition(afterSales.getCondition());
        a2.setCustomer(afterSales.getCustomer());
        a2.setCustomerAddr(afterSales.getCustomerAddr());
        a2.setConnection(afterSales.getConnection());
        a2.setDeviceType(afterSales.getDeviceType());
        a2.setDeviceid(afterSales.getDeviceid());
        a2.setFormDate(afterSales.getFormDate());
        a2.setFormType(afterSales.getFormType());
        a2.setProductionDate(afterSales.getProductionDate());
        a2.setProductionID(afterSales.getProductionID());
        a2.setQuality(afterSales.getQuality());
        a2.setQuetion(afterSales.getQuetion());
        a2.setSalesman(afterSales.getSalesman());
        a2.setTel(afterSales.getTel());
        a2.setTexture(afterSales.getTexture());
        a2.setModifyTime(afterSales.getModifyTime());
        a2.setCreateBy(afterSales.getCreateBy());
        a2.setParams(afterSales.getParams());
        a2.setRemark(afterSales.getRemark());
        a2.setSearchValue(afterSales.getSearchValue());
        a2.setUpdateTime(afterSales.getUpdateTime());
        a2.setUpdateBy(afterSales.getUpdateBy());
        a2.setAttachment(afterSales.getAttachment());
        a2.setRemark(afterSales.getRemark());
        int r = aftersalesBackMapper.insertAftersalesBack(a2);

        return r;
    }

    @Override
    public int deleAfterSales(AfterSales afterSales) {
        Long id = afterSales.getId();
        int r = this.deleteAfterSalesById(id);
        return r;
    }

    @Override
    public int editSales(AfterSales afterSales, com.ruoyi.system.domain.SysFileInfo fileInfo, org.springframework.web.multipart.MultipartFile attachmentFile )   {

        try {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, attachmentFile);
            fileInfo.setFileName(fileName);
            fileInfo.setFilePath(filePath);
            sysFileInfoService.insertSysFileInfo(fileInfo);
            Long id = fileInfo.getFileId();
            afterSales.setAttachment(id + "");
            this.updateAfterSales(afterSales);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
