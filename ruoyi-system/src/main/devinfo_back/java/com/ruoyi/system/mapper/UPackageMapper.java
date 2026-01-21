package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.UPackage;

/**
 * 包装箱Mapper接口
 * 
 * @author pengweitao
 * @date 2025-06-28
 */
public interface UPackageMapper 
{
    /**
     * 查询包装箱
     * 
     * @param id 包装箱主键
     * @return 包装箱
     */
    public UPackage selectUPackageById(Long id);

    /**
     * 查询包装箱列表
     * 
     * @param uPackage 包装箱
     * @return 包装箱集合
     */
    public List<UPackage> selectUPackageList(UPackage uPackage);

    /**
     * 新增包装箱
     * 
     * @param uPackage 包装箱
     * @return 结果
     */
    public int insertUPackage(UPackage uPackage);

    /**
     * 修改包装箱
     * 
     * @param uPackage 包装箱
     * @return 结果
     */
    public int updateUPackage(UPackage uPackage);

    /**
     * 删除包装箱
     * 
     * @param id 包装箱主键
     * @return 结果
     */
    public int deleteUPackageById(Long id);

    /**
     * 批量删除包装箱
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUPackageByIds(String[] ids);
}
