package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UTextureMapper;
import com.ruoyi.system.domain.UTexture;
import com.ruoyi.system.service.IUTextureService;
import com.ruoyi.common.core.text.Convert;

/**
 * 材质Service业务层处理
 * 
 * @author pengweitao
 * @date 2025-06-28
 */
@Service
public class UTextureServiceImpl implements IUTextureService 
{
    @Autowired
    private UTextureMapper uTextureMapper;

    /**
     * 查询材质
     * 
     * @param id 材质主键
     * @return 材质
     */
    @Override
    public UTexture selectUTextureById(Long id)
    {
        return uTextureMapper.selectUTextureById(id);
    }

    /**
     * 查询材质列表
     * 
     * @param uTexture 材质
     * @return 材质
     */
    @Override
    public List<UTexture> selectUTextureList(UTexture uTexture)
    {
        return uTextureMapper.selectUTextureList(uTexture);
    }

    /**
     * 新增材质
     * 
     * @param uTexture 材质
     * @return 结果
     */
    @Override
    public int insertUTexture(UTexture uTexture)
    {
        return uTextureMapper.insertUTexture(uTexture);
    }

    /**
     * 修改材质
     * 
     * @param uTexture 材质
     * @return 结果
     */
    @Override
    public int updateUTexture(UTexture uTexture)
    {
        return uTextureMapper.updateUTexture(uTexture);
    }

    /**
     * 批量删除材质
     * 
     * @param ids 需要删除的材质主键
     * @return 结果
     */
    @Override
    public int deleteUTextureByIds(String ids)
    {
        return uTextureMapper.deleteUTextureByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除材质信息
     * 
     * @param id 材质主键
     * @return 结果
     */
    @Override
    public int deleteUTextureById(Long id)
    {
        return uTextureMapper.deleteUTextureById(id);
    }
}
