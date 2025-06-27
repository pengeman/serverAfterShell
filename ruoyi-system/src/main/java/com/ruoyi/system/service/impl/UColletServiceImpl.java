package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UColletMapper;
import com.ruoyi.system.domain.UCollet;
import com.ruoyi.system.service.IUColletService;
import com.ruoyi.common.core.text.Convert;

/**
 * 底托Service业务层处理
 * 
 * @author pengweitao
 * @date 2025-06-27
 */
@Service
public class UColletServiceImpl implements IUColletService 
{
    @Autowired
    private UColletMapper uColletMapper;

    /**
     * 查询底托
     * 
     * @param id 底托主键
     * @return 底托
     */
    @Override
    public UCollet selectUColletById(Long id)
    {
        return uColletMapper.selectUColletById(id);
    }

    /**
     * 查询底托列表
     * 
     * @param uCollet 底托
     * @return 底托
     */
    @Override
    public List<UCollet> selectUColletList(UCollet uCollet)
    {
        return uColletMapper.selectUColletList(uCollet);
    }

    /**
     * 新增底托
     * 
     * @param uCollet 底托
     * @return 结果
     */
    @Override
    public int insertUCollet(UCollet uCollet)
    {
        return uColletMapper.insertUCollet(uCollet);
    }

    /**
     * 修改底托
     * 
     * @param uCollet 底托
     * @return 结果
     */
    @Override
    public int updateUCollet(UCollet uCollet)
    {
        return uColletMapper.updateUCollet(uCollet);
    }

    /**
     * 批量删除底托
     * 
     * @param ids 需要删除的底托主键
     * @return 结果
     */
    @Override
    public int deleteUColletByIds(String ids)
    {
        return uColletMapper.deleteUColletByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除底托信息
     * 
     * @param id 底托主键
     * @return 结果
     */
    @Override
    public int deleteUColletById(Long id)
    {
        return uColletMapper.deleteUColletById(id);
    }
}
