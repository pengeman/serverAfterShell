package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.USheet;

/**
 * 板片Mapper接口
 * 
 * @author pengweitao
 * @date 2025-06-28
 */
public interface USheetMapper 
{
    /**
     * 查询板片
     * 
     * @param id 板片主键
     * @return 板片
     */
    public USheet selectUSheetById(Long id);

    /**
     * 查询板片列表
     * 
     * @param uSheet 板片
     * @return 板片集合
     */
    public List<USheet> selectUSheetList(USheet uSheet);

    /**
     * 新增板片
     * 
     * @param uSheet 板片
     * @return 结果
     */
    public int insertUSheet(USheet uSheet);

    /**
     * 修改板片
     * 
     * @param uSheet 板片
     * @return 结果
     */
    public int updateUSheet(USheet uSheet);

    /**
     * 删除板片
     * 
     * @param id 板片主键
     * @return 结果
     */
    public int deleteUSheetById(Long id);

    /**
     * 批量删除板片
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUSheetByIds(String[] ids);
}
