package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BuyerinfoMapper;
import com.ruoyi.system.domain.Buyerinfo;
import com.ruoyi.system.service.IBuyerinfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 购买方档案Service业务层处理
 * 
 * @author pengweitao
 * @date 2024-08-23
 */
@Service
public class BuyerinfoServiceImpl implements IBuyerinfoService 
{
    @Autowired
    private BuyerinfoMapper buyerinfoMapper;

    /**
     * 查询购买方档案
     * 
     * @param id 购买方档案主键
     * @return 购买方档案
     */
    @Override
    public Buyerinfo selectBuyerinfoById(Long id)
    {
        return buyerinfoMapper.selectBuyerinfoById(id);
    }

    /**
     * 查询购买方档案列表
     * 
     * @param buyerinfo 购买方档案
     * @return 购买方档案
     */
    @Override
    public List<Buyerinfo> selectBuyerinfoList(Buyerinfo buyerinfo)
    {
        return buyerinfoMapper.selectBuyerinfoList(buyerinfo);
    }

    /**
     * 新增购买方档案
     * 
     * @param buyerinfo 购买方档案
     * @return 结果
     */
    @Override
    public int insertBuyerinfo(Buyerinfo buyerinfo)
    {
        return buyerinfoMapper.insertBuyerinfo(buyerinfo);
    }

    /**
     * 修改购买方档案
     * 
     * @param buyerinfo 购买方档案
     * @return 结果
     */
    @Override
    public int updateBuyerinfo(Buyerinfo buyerinfo)
    {
        return buyerinfoMapper.updateBuyerinfo(buyerinfo);
    }

    /**
     * 批量删除购买方档案
     * 
     * @param ids 需要删除的购买方档案主键
     * @return 结果
     */
    @Override
    public int deleteBuyerinfoByIds(String ids)
    {
        return buyerinfoMapper.deleteBuyerinfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除购买方档案信息
     * 
     * @param id 购买方档案主键
     * @return 结果
     */
    @Override
    public int deleteBuyerinfoById(Long id)
    {
        return buyerinfoMapper.deleteBuyerinfoById(id);
    }
}
