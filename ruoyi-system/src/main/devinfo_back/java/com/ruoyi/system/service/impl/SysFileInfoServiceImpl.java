package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysFileInfoMapper;
import com.ruoyi.system.domain.SysFileInfo;
import com.ruoyi.system.service.ISysFileInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 上传文件信息Service业务层处理
 * 
 * @author peng
 * @date 2024-08-09
 */
@Service
public class SysFileInfoServiceImpl implements ISysFileInfoService 
{
    @Autowired
    private SysFileInfoMapper sysFileInfoMapper;

    /**
     * 查询上传文件信息
     * 
     * @param fileId 上传文件信息主键
     * @return 上传文件信息
     */
    @Override
    public SysFileInfo selectSysFileInfoByFileId(Long fileId)
    {
        return sysFileInfoMapper.selectSysFileInfoByFileId(fileId);
    }

    /**
     * 查询上传文件信息列表
     * 
     * @param sysFileInfo 上传文件信息
     * @return 上传文件信息
     */
    @Override
    public List<SysFileInfo> selectSysFileInfoList(SysFileInfo sysFileInfo)
    {
        return sysFileInfoMapper.selectSysFileInfoList(sysFileInfo);
    }

    /**
     * 新增上传文件信息
     * 
     * @param sysFileInfo 上传文件信息
     * @return 结果
     */
    @Override
    public int insertSysFileInfo(SysFileInfo sysFileInfo)
    {
        return sysFileInfoMapper.insertSysFileInfo(sysFileInfo);
    }

    /**
     * 修改上传文件信息
     * 
     * @param sysFileInfo 上传文件信息
     * @return 结果
     */
    @Override
    public int updateSysFileInfo(SysFileInfo sysFileInfo)
    {
        return sysFileInfoMapper.updateSysFileInfo(sysFileInfo);
    }

    /**
     * 批量删除上传文件信息
     * 
     * @param fileIds 需要删除的上传文件信息主键
     * @return 结果
     */
    @Override
    public int deleteSysFileInfoByFileIds(String fileIds)
    {
        return sysFileInfoMapper.deleteSysFileInfoByFileIds(Convert.toStrArray(fileIds));
    }

    /**
     * 删除上传文件信息信息
     * 
     * @param fileId 上传文件信息主键
     * @return 结果
     */
    @Override
    public int deleteSysFileInfoByFileId(Long fileId)
    {
        return sysFileInfoMapper.deleteSysFileInfoByFileId(fileId);
    }
}
