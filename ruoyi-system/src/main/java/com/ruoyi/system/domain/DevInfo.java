package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备信息档案对象 devInfo
 * 
 * @author pengweitao
 * @date 2026-01-21
 */
public class DevInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** serial number序列号 */
    @Excel(name = "serial number序列号")
    private String serialid;

    /** 设备型号 */
    @Excel(name = "设备型号")
    private String devType;

    /** 制造日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "制造日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date makedate;

    /** 合同 */
    private String controct;

    /** 购买方 */
    @Excel(name = "购买方")
    private Long buyerid;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userid;

    /** 设备类别 */
    private Long theclass;

    /** 制造日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "制造日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date factoryDate;

    /** 质保期限 */
    @Excel(name = "质保期限")
    private Long warrantyPeriod;

    /** 质保 */
    private Long guaranteePeriod;

    /** 销售日期 */
    private Date salesDate;

    /** 服务历史 */
    private Long serverStory;

    /** 创建人编号 当前用户ID */
    private Long CreatorId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setSerialid(String serialid) 
    {
        this.serialid = serialid;
    }

    public String getSerialid() 
    {
        return serialid;
    }

    public void setDevType(String devType) 
    {
        this.devType = devType;
    }

    public String getDevType() 
    {
        return devType;
    }

    public void setMakedate(Date makedate) 
    {
        this.makedate = makedate;
    }

    public Date getMakedate() 
    {
        return makedate;
    }

    public void setControct(String controct) 
    {
        this.controct = controct;
    }

    public String getControct() 
    {
        return controct;
    }

    public void setBuyerid(Long buyerid) 
    {
        this.buyerid = buyerid;
    }

    public Long getBuyerid() 
    {
        return buyerid;
    }

    public void setUserid(Long userid) 
    {
        this.userid = userid;
    }

    public Long getUserid() 
    {
        return userid;
    }

    public void setTheclass(Long theclass) 
    {
        this.theclass = theclass;
    }

    public Long getTheclass() 
    {
        return theclass;
    }

    public void setFactoryDate(Date factoryDate) 
    {
        this.factoryDate = factoryDate;
    }

    public Date getFactoryDate() 
    {
        return factoryDate;
    }

    public void setWarrantyPeriod(Long warrantyPeriod) 
    {
        this.warrantyPeriod = warrantyPeriod;
    }

    public Long getWarrantyPeriod() 
    {
        return warrantyPeriod;
    }

    public void setGuaranteePeriod(Long guaranteePeriod) 
    {
        this.guaranteePeriod = guaranteePeriod;
    }

    public Long getGuaranteePeriod() 
    {
        return guaranteePeriod;
    }

    public void setSalesDate(Date salesDate) 
    {
        this.salesDate = salesDate;
    }

    public Date getSalesDate() 
    {
        return salesDate;
    }

    public void setServerStory(Long serverStory) 
    {
        this.serverStory = serverStory;
    }

    public Long getServerStory() 
    {
        return serverStory;
    }

    public void setCreatorId(Long CreatorId) 
    {
        this.CreatorId = CreatorId;
    }

    public Long getCreatorId() 
    {
        return CreatorId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("serialid", getSerialid())
            .append("devType", getDevType())
            .append("makedate", getMakedate())
            .append("controct", getControct())
            .append("buyerid", getBuyerid())
            .append("userid", getUserid())
            .append("theclass", getTheclass())
            .append("factoryDate", getFactoryDate())
            .append("warrantyPeriod", getWarrantyPeriod())
            .append("guaranteePeriod", getGuaranteePeriod())
            .append("salesDate", getSalesDate())
            .append("serverStory", getServerStory())
            .append("CreatorId", getCreatorId())
            .append("CreateTime", getCreateTime())
            .toString();
    }
}
