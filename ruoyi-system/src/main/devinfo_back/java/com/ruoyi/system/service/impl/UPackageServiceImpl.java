package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UPackageMapper;
import com.ruoyi.system.domain.UPackage;
import com.ruoyi.system.service.IUPackageService;
import com.ruoyi.common.core.text.Convert;

/**
 * 包装箱Service业务层处理
 * 
 * @author pengweitao
 * @date 2025-06-28
 */
@Service
public class UPackageServiceImpl implements IUPackageService 
{
    @Autowired
    private UPackageMapper uPackageMapper;

    /**
     * 查询包装箱
     * 
     * @param id 包装箱主键
     * @return 包装箱
     */
    @Override
    public UPackage selectUPackageById(Long id)
    {
        return uPackageMapper.selectUPackageById(id);
    }

    /**
     * 查询包装箱列表
     * 
     * @param uPackage 包装箱
     * @return 包装箱
     */
    @Override
    public List<UPackage> selectUPackageList(UPackage uPackage)
    {
        return uPackageMapper.selectUPackageList(uPackage);
    }

    /**
     * 新增包装箱
     * 
     * @param uPackage 包装箱
     * @return 结果
     */
    @Override
    public int insertUPackage(UPackage uPackage)
    {
        return uPackageMapper.insertUPackage(uPackage);
    }

    /**
     * 修改包装箱
     * 
     * @param uPackage 包装箱
     * @return 结果
     */
    @Override
    public int updateUPackage(UPackage uPackage)
    {
        return uPackageMapper.updateUPackage(uPackage);
    }

    /**
     * 批量删除包装箱
     * 
     * @param ids 需要删除的包装箱主键
     * @return 结果
     */
    @Override
    public int deleteUPackageByIds(String ids)
    {
        return uPackageMapper.deleteUPackageByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除包装箱信息
     * 
     * @param id 包装箱主键
     * @return 结果
     */
    @Override
    public int deleteUPackageById(Long id)
    {
        return uPackageMapper.deleteUPackageById(id);
    }
}
