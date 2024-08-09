package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysFileInfo;

/**
 * 上传文件信息Mapper接口
 * 
 * @author peng
 * @date 2024-08-09
 */
public interface SysFileInfoMapper 
{
    /**
     * 查询上传文件信息
     * 
     * @param fileId 上传文件信息主键
     * @return 上传文件信息
     */
    public SysFileInfo selectSysFileInfoByFileId(Long fileId);

    /**
     * 查询上传文件信息列表
     * 
     * @param sysFileInfo 上传文件信息
     * @return 上传文件信息集合
     */
    public List<SysFileInfo> selectSysFileInfoList(SysFileInfo sysFileInfo);

    /**
     * 新增上传文件信息
     * 
     * @param sysFileInfo 上传文件信息
     * @return 结果
     */
    public int insertSysFileInfo(SysFileInfo sysFileInfo);

    /**
     * 修改上传文件信息
     * 
     * @param sysFileInfo 上传文件信息
     * @return 结果
     */
    public int updateSysFileInfo(SysFileInfo sysFileInfo);

    /**
     * 删除上传文件信息
     * 
     * @param fileId 上传文件信息主键
     * @return 结果
     */
    public int deleteSysFileInfoByFileId(Long fileId);

    /**
     * 批量删除上传文件信息
     * 
     * @param fileIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysFileInfoByFileIds(String[] fileIds);
}
