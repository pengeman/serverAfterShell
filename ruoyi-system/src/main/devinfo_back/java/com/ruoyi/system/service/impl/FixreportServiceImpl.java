package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FixreportMapper;
import com.ruoyi.system.domain.Fixreport;
import com.ruoyi.system.service.IFixreportService;
import com.ruoyi.common.core.text.Convert;

/**
 * 维修分析报告Service业务层处理
 * 
 * @author pengweitao
 * @date 2024-07-28
 */
@Service
public class FixreportServiceImpl implements IFixreportService 
{
    @Autowired
    private FixreportMapper fixreportMapper;

    /**
     * 查询维修分析报告
     * 
     * @param id 维修分析报告主键
     * @return 维修分析报告
     */
    @Override
    public Fixreport selectFixreportById(Long id)
    {
        return fixreportMapper.selectFixreportById(id);
    }

    /**
     * 查询维修分析报告列表
     * 
     * @param fixreport 维修分析报告
     * @return 维修分析报告
     */
    @Override
    public List<Fixreport> selectFixreportList(Fixreport fixreport)
    {
        return fixreportMapper.selectFixreportList(fixreport);
    }

    /**
     * 新增维修分析报告
     * 
     * @param fixreport 维修分析报告
     * @return 结果
     */
    @Override
    public int insertFixreport(Fixreport fixreport)
    {
        fixreport.setCreateTime(DateUtils.getNowDate());
        return fixreportMapper.insertFixreport(fixreport);
    }

    /**
     * 修改维修分析报告
     * 
     * @param fixreport 维修分析报告
     * @return 结果
     */
    @Override
    public int updateFixreport(Fixreport fixreport)
    {
        return fixreportMapper.updateFixreport(fixreport);
    }

    /**
     * 批量删除维修分析报告
     * 
     * @param ids 需要删除的维修分析报告主键
     * @return 结果
     */
    @Override
    public int deleteFixreportByIds(String ids)
    {
        return fixreportMapper.deleteFixreportByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除维修分析报告信息
     * 
     * @param id 维修分析报告主键
     * @return 结果
     */
    @Override
    public int deleteFixreportById(Long id)
    {
        return fixreportMapper.deleteFixreportById(id);
    }
}
