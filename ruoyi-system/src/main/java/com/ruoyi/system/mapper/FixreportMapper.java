package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Fixreport;

/**
 * 维修分析报告Mapper接口
 * 
 * @author pengweitao
 * @date 2024-07-28
 */
public interface FixreportMapper 
{
    /**
     * 查询维修分析报告
     * 
     * @param id 维修分析报告主键
     * @return 维修分析报告
     */
    public Fixreport selectFixreportById(Long id);

    /**
     * 查询维修分析报告列表
     * 
     * @param fixreport 维修分析报告
     * @return 维修分析报告集合
     */
    public List<Fixreport> selectFixreportList(Fixreport fixreport);

    /**
     * 新增维修分析报告
     * 
     * @param fixreport 维修分析报告
     * @return 结果
     */
    public int insertFixreport(Fixreport fixreport);

    /**
     * 修改维修分析报告
     * 
     * @param fixreport 维修分析报告
     * @return 结果
     */
    public int updateFixreport(Fixreport fixreport);

    /**
     * 删除维修分析报告
     * 
     * @param id 维修分析报告主键
     * @return 结果
     */
    public int deleteFixreportById(Long id);

    /**
     * 批量删除维修分析报告
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFixreportByIds(String[] ids);
}
