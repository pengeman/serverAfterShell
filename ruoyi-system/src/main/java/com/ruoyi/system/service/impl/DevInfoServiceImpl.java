package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.system.domain.Buyerinfo;
import com.ruoyi.system.domain.Userinfo;
import com.ruoyi.system.mapper.BuyerinfoMapper;
import com.ruoyi.system.mapper.UserinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.DevInfoMapper;
import com.ruoyi.system.domain.DevInfo;
import com.ruoyi.system.service.IDevInfoService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.transaction.annotation.Transactional;

/**
 * 设备档案Service业务层处理
 *
 * @author pengweitao
 * @date 2024-08-22
 */
@Service
public class DevInfoServiceImpl implements IDevInfoService {
    @Autowired
    private DevInfoMapper devInfoMapper;
    @Autowired
    private UserinfoMapper userinfoMapper;
    @Autowired
    private BuyerinfoMapper buyerinfoMapper;

    /**
     * 查询设备档案
     *
     * @param id 设备档案主键
     * @return 设备档案
     */
    @Override
    public DevInfo selectDevInfoById(Long id) {
        return devInfoMapper.selectDevInfoById(id);
    }

    /**
     * 查询设备档案列表
     *
     * @param devInfo 设备档案
     * @return 设备档案
     */
    @Override
    public List<DevInfo> selectDevInfoList(DevInfo devInfo) {
        return devInfoMapper.selectDevInfoList(devInfo);
    }

    /**
     * 新增设备档案
     *
     * @param devInfo 设备档案
     * @return 结果
     */
    @Override
    public int insertDevInfo(DevInfo devInfo) {
        return devInfoMapper.insertDevInfo(devInfo);
    }

    /**
     * 修改设备档案
     *
     * @param devInfo 设备档案
     * @return 结果
     */
    @Override
    public int updateDevInfo(DevInfo devInfo) {
        return devInfoMapper.updateDevInfo(devInfo);
    }

    /**
     * 批量删除设备档案
     *
     * @param ids 需要删除的设备档案主键
     * @return 结果
     */
    @Override
    public int deleteDevInfoByIds(String ids) {
        return devInfoMapper.deleteDevInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备档案信息
     *
     * @param id 设备档案主键
     * @return 结果
     */
    @Override
    public int deleteDevInfoById(Long id) {
        return devInfoMapper.deleteDevInfoById(id);
    }

    @Transactional
    @Override
    public int insetDevInfoGroup(DevInfo devInfo, Buyerinfo buyerinfo, Userinfo userInfo) {
        int userid = userinfoMapper.insertUserinfo(userInfo);
        int buyerid = buyerinfoMapper.insertBuyerinfo(buyerinfo);
        devInfo.setUserid(String.valueOf((userid)));
        devInfo.setBuyerid(String.valueOf((buyerid)));
        int r = devInfoMapper.insertDevInfo(devInfo);


        return r;
    }
}
