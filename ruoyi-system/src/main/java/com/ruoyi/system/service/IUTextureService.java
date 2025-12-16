package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.UTexture;

/**
 * 材质Service接口
 * 
 * @author pengweitao
 * @date 2025-06-28
 */
public interface IUTextureService 
{
    /**
     * 查询材质
     * 
     * @param id 材质主键
     * @return 材质
     */
    public UTexture selectUTextureById(Long id);

    /**
     * 查询材质列表
     * 
     * @param uTexture 材质
     * @return 材质集合
     */
    public List<UTexture> selectUTextureList(UTexture uTexture);

    /**
     * 新增材质
     * 
     * @param uTexture 材质
     * @return 结果
     */
    public int insertUTexture(UTexture uTexture);

    /**
     * 修改材质
     * 
     * @param uTexture 材质
     * @return 结果
     */
    public int updateUTexture(UTexture uTexture);

    /**
     * 批量删除材质
     * 
     * @param ids 需要删除的材质主键集合
     * @return 结果
     */
    public int deleteUTextureByIds(String ids);

    /**
     * 删除材质信息
     * 
     * @param id 材质主键
     * @return 结果
     */
    public int deleteUTextureById(Long id);
}
