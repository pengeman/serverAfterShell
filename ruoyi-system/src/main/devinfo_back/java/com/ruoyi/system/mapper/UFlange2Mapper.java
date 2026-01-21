package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.UFlange2;

/**
 * 法兰-JB/T81-94国标Mapper接口
 * 
 * @author pengweitao
 * @date 2025-06-28
 */
public interface UFlange2Mapper 
{
    /**
     * 查询法兰-JB/T81-94国标
     * 
     * @param id 法兰-JB/T81-94国标主键
     * @return 法兰-JB/T81-94国标
     */
    public UFlange2 selectUFlange2ById(Long id);

    /**
     * 查询法兰-JB/T81-94国标列表
     * 
     * @param uFlange2 法兰-JB/T81-94国标
     * @return 法兰-JB/T81-94国标集合
     */
    public List<UFlange2> selectUFlange2List(UFlange2 uFlange2);

    /**
     * 新增法兰-JB/T81-94国标
     * 
     * @param uFlange2 法兰-JB/T81-94国标
     * @return 结果
     */
    public int insertUFlange2(UFlange2 uFlange2);

    /**
     * 修改法兰-JB/T81-94国标
     * 
     * @param uFlange2 法兰-JB/T81-94国标
     * @return 结果
     */
    public int updateUFlange2(UFlange2 uFlange2);

    /**
     * 删除法兰-JB/T81-94国标
     * 
     * @param id 法兰-JB/T81-94国标主键
     * @return 结果
     */
    public int deleteUFlange2ById(Long id);

    /**
     * 批量删除法兰-JB/T81-94国标
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUFlange2ByIds(String[] ids);
}
