package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.UCollet;

/**
 * 底托Mapper接口
 * 
 * @author pengweitao
 * @date 2025-06-27
 */
public interface UColletMapper 
{
    /**
     * 查询底托
     * 
     * @param id 底托主键
     * @return 底托
     */
    public UCollet selectUColletById(Long id);

    /**
     * 查询底托列表
     * 
     * @param uCollet 底托
     * @return 底托集合
     */
    public List<UCollet> selectUColletList(UCollet uCollet);

    /**
     * 新增底托
     * 
     * @param uCollet 底托
     * @return 结果
     */
    public int insertUCollet(UCollet uCollet);

    /**
     * 修改底托
     * 
     * @param uCollet 底托
     * @return 结果
     */
    public int updateUCollet(UCollet uCollet);

    /**
     * 删除底托
     * 
     * @param id 底托主键
     * @return 结果
     */
    public int deleteUColletById(Long id);

    /**
     * 批量删除底托
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUColletByIds(String[] ids);
}
