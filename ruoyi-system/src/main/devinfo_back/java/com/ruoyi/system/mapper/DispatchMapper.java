package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Dispatch;

/**
 * 派工单Mapper接口
 * 
 * @author pengweitao
 * @date 2026-01-20
 */
public interface DispatchMapper 
{
    /**
     * 查询派工单
     * 
     * @param id 派工单主键
     * @return 派工单
     */
    public Dispatch selectDispatchById(Long id);

    /**
     * 查询派工单列表
     * 
     * @param dispatch 派工单
     * @return 派工单集合
     */
    public List<Dispatch> selectDispatchList(Dispatch dispatch);

    /**
     * 新增派工单
     * 
     * @param dispatch 派工单
     * @return 结果
     */
    public int insertDispatch(Dispatch dispatch);

    /**
     * 修改派工单
     * 
     * @param dispatch 派工单
     * @return 结果
     */
    public int updateDispatch(Dispatch dispatch);

    /**
     * 删除派工单
     * 
     * @param id 派工单主键
     * @return 结果
     */
    public int deleteDispatchById(Long id);

    /**
     * 批量删除派工单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDispatchByIds(String[] ids);
}
