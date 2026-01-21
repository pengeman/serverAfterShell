package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DispatchMapper;
import com.ruoyi.system.domain.Dispatch;
import com.ruoyi.system.service.IDispatchService;
import com.ruoyi.common.core.text.Convert;

/**
 * 派工单Service业务层处理
 * 
 * @author pengweitao
 * @date 2026-01-20
 */
@Service
public class DispatchServiceImpl implements IDispatchService 
{
    @Autowired
    private DispatchMapper dispatchMapper;

    /**
     * 查询派工单
     * 
     * @param id 派工单主键
     * @return 派工单
     */
    @Override
    public Dispatch selectDispatchById(Long id)
    {
        return dispatchMapper.selectDispatchById(id);
    }

    /**
     * 查询派工单列表
     * 
     * @param dispatch 派工单
     * @return 派工单
     */
    @Override
    public List<Dispatch> selectDispatchList(Dispatch dispatch)
    {
        return dispatchMapper.selectDispatchList(dispatch);
    }

    /**
     * 新增派工单
     * 
     * @param dispatch 派工单
     * @return 结果
     */
    @Override
    public int insertDispatch(Dispatch dispatch)
    {
        return dispatchMapper.insertDispatch(dispatch);
    }

    /**
     * 修改派工单
     * 
     * @param dispatch 派工单
     * @return 结果
     */
    @Override
    public int updateDispatch(Dispatch dispatch)
    {
        return dispatchMapper.updateDispatch(dispatch);
    }

    /**
     * 批量删除派工单
     * 
     * @param ids 需要删除的派工单主键
     * @return 结果
     */
    @Override
    public int deleteDispatchByIds(String ids)
    {
        return dispatchMapper.deleteDispatchByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除派工单信息
     * 
     * @param id 派工单主键
     * @return 结果
     */
    @Override
    public int deleteDispatchById(Long id)
    {
        return dispatchMapper.deleteDispatchById(id);
    }
}
