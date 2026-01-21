package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.AftersalesBackMapper;
import com.ruoyi.system.domain.AftersalesBack;
import com.ruoyi.system.service.IAftersalesBackService;
import com.ruoyi.common.core.text.Convert;

/**
 * 售后派工单备份Service业务层处理
 * 
 * @author peng
 * @date 2024-07-27
 */
@Service
public class AftersalesBackServiceImpl implements IAftersalesBackService 
{
    @Autowired
    private AftersalesBackMapper aftersalesBackMapper;

    /**
     * 查询售后派工单备份
     * 
     * @param id 售后派工单备份主键
     * @return 售后派工单备份
     */
    @Override
    public AftersalesBack selectAftersalesBackById(Long id)
    {
        return aftersalesBackMapper.selectAftersalesBackById(id);
    }

    /**
     * 查询售后派工单备份列表
     * 
     * @param aftersalesBack 售后派工单备份
     * @return 售后派工单备份
     */
    @Override
    public List<AftersalesBack> selectAftersalesBackList(AftersalesBack aftersalesBack)
    {
        return aftersalesBackMapper.selectAftersalesBackList(aftersalesBack);
    }

    /**
     * 新增售后派工单备份
     * 
     * @param aftersalesBack 售后派工单备份
     * @return 结果
     */
    @Override
    public int insertAftersalesBack(AftersalesBack aftersalesBack)
    {
        aftersalesBack.setCreateTime(DateUtils.getNowDate());
        return aftersalesBackMapper.insertAftersalesBack(aftersalesBack);
    }

    /**
     * 修改售后派工单备份
     * 
     * @param aftersalesBack 售后派工单备份
     * @return 结果
     */
    @Override
    public int updateAftersalesBack(AftersalesBack aftersalesBack)
    {
        return aftersalesBackMapper.updateAftersalesBack(aftersalesBack);
    }

    /**
     * 批量删除售后派工单备份
     * 
     * @param ids 需要删除的售后派工单备份主键
     * @return 结果
     */
    @Override
    public int deleteAftersalesBackByIds(String ids)
    {
        return aftersalesBackMapper.deleteAftersalesBackByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除售后派工单备份信息
     * 
     * @param id 售后派工单备份主键
     * @return 结果
     */
    @Override
    public int deleteAftersalesBackById(Long id)
    {
        return aftersalesBackMapper.deleteAftersalesBackById(id);
    }

    @Override
    public int gopassAfterSales(Long id) {
        return 0;
    }
}
