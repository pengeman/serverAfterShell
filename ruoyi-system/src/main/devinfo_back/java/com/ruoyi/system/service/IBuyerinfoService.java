package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Buyerinfo;

/**
 * 购买方档案Service接口
 * 
 * @author pengweitao
 * @date 2024-08-23
 */
public interface IBuyerinfoService 
{
    /**
     * 查询购买方档案
     * 
     * @param id 购买方档案主键
     * @return 购买方档案
     */
    public Buyerinfo selectBuyerinfoById(Long id);

    /**
     * 查询购买方档案列表
     * 
     * @param buyerinfo 购买方档案
     * @return 购买方档案集合
     */
    public List<Buyerinfo> selectBuyerinfoList(Buyerinfo buyerinfo);

    /**
     * 新增购买方档案
     * 
     * @param buyerinfo 购买方档案
     * @return 结果
     */
    public int insertBuyerinfo(Buyerinfo buyerinfo);

    /**
     * 修改购买方档案
     * 
     * @param buyerinfo 购买方档案
     * @return 结果
     */
    public int updateBuyerinfo(Buyerinfo buyerinfo);

    /**
     * 批量删除购买方档案
     * 
     * @param ids 需要删除的购买方档案主键集合
     * @return 结果
     */
    public int deleteBuyerinfoByIds(String ids);

    /**
     * 删除购买方档案信息
     * 
     * @param id 购买方档案主键
     * @return 结果
     */
    public int deleteBuyerinfoById(Long id);
}
