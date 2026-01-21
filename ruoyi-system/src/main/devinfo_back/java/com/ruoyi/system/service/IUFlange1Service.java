package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.UFlange1;

/**
 * 法兰-HG/T20592-09化工Service接口
 * 
 * @author pengweitao
 * @date 2025-06-27
 */
public interface IUFlange1Service 
{
    /**
     * 查询法兰-HG/T20592-09化工
     * 
     * @param id 法兰-HG/T20592-09化工主键
     * @return 法兰-HG/T20592-09化工
     */
    public UFlange1 selectUFlange1ById(Long id);

    /**
     * 查询法兰-HG/T20592-09化工列表
     * 
     * @param uFlange1 法兰-HG/T20592-09化工
     * @return 法兰-HG/T20592-09化工集合
     */
    public List<UFlange1> selectUFlange1List(UFlange1 uFlange1);

    /**
     * 新增法兰-HG/T20592-09化工
     * 
     * @param uFlange1 法兰-HG/T20592-09化工
     * @return 结果
     */
    public int insertUFlange1(UFlange1 uFlange1);

    /**
     * 修改法兰-HG/T20592-09化工
     * 
     * @param uFlange1 法兰-HG/T20592-09化工
     * @return 结果
     */
    public int updateUFlange1(UFlange1 uFlange1);

    /**
     * 批量删除法兰-HG/T20592-09化工
     * 
     * @param ids 需要删除的法兰-HG/T20592-09化工主键集合
     * @return 结果
     */
    public int deleteUFlange1ByIds(String ids);

    /**
     * 删除法兰-HG/T20592-09化工信息
     * 
     * @param id 法兰-HG/T20592-09化工主键
     * @return 结果
     */
    public int deleteUFlange1ById(Long id);
}
