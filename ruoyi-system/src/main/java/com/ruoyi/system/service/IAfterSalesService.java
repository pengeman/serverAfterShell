package com.ruoyi.system.service;

import java.io.IOException;
import java.util.List;
import com.ruoyi.system.domain.AfterSales;
import com.ruoyi.system.domain.AftersalesBack;
import com.ruoyi.system.domain.Note;

/**
 * afterSalesService接口
 * 
 * @author peng
 * @date 2024-07-04
 */
public interface IAfterSalesService 
{
    /**
     * 查询afterSales
     * 
     * @param id afterSales主键
     * @return afterSales
     */
    public AfterSales selectAfterSalesById(Long id);

    /**
     * 查询afterSales列表
     * 
     * @param afterSales afterSales
     * @return afterSales集合
     */
    public List<AfterSales> selectAfterSalesList(AfterSales afterSales);

    /**
     * 新增afterSales
     * 
     * @param afterSales afterSales
     * @return 结果
     */
    public int insertAfterSales(AfterSales afterSales);

    /**
     * 修改afterSales
     * 
     * @param afterSales afterSales
     * @return 结果
     */
    public int updateAfterSales(AfterSales afterSales);

    /**
     * 批量删除afterSales
     * 
     * @param ids 需要删除的afterSales主键集合
     * @return 结果
     */
    public int deleteAfterSalesByIds(String ids);

    /**
     * 删除afterSales信息
     * 
     * @param id afterSales主键
     * @return 结果
     */
    public int deleteAfterSalesById(Long id);

    /**
     * 通过售后单，售后完成
     */
    public int gopassSales(AfterSales afterSales, String gopassFileName);
    /**
     * by peng
     * 导入售后单，from json
     */
    public int importAfterSalesFromJson(String afterSalesJson);

    /**
     * 批准通过售后单<br>
     * 将派工单的数据复制到他的备份表中，将
     * @param afterSalesID,aftersalesBack
     * @return
     */
    public int gopassAfterSales(Long afterSalesID, AftersalesBack aftersalesBack);

    /**
     * 将售后派工单备份
     * @param afterSales
     * @return
     */
    public int backAfterSales(AfterSales afterSales);

    /**
     * 删除售后派工单
     * @param afterSales
     * @return
     */
    public int deleAfterSales(AfterSales afterSales);

    /**
     * 编辑派工单(afterSales),update afterSales,保存便签note，保存派工单影像file。
     * @return int ,1成功，0失败
     */
    public int editSales(AfterSales afterSales, com.ruoyi.system.domain.SysFileInfo  fileInfo,org.springframework.web.multipart.MultipartFile attachmentFile ) ;
}
