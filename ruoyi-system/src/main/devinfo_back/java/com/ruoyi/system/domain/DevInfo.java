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
 * @date 2026-01-12
 */
public class DevInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 出厂编号 */
    @Excel(name = "出厂编号")
    private String serialid;

    /** 设备型号 */
    @Excel(name = "设备型号")
    private String devType;

    /** 制造日期 */
    private Date makedate;

    /** 合同 */
    private String controct;

    /** 购买方 */
    @Excel(name = "购买方")
    private Long buyerid;

    /** 用户 */
    @Excel(name = "用户")
    private Long userid;

    /** 设备类别 */
    @Excel(name = "设备类别")
    private Long theclass;

    /** 出厂日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出厂日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date menufactDate;

    /** 质保 */
    @Excel(name = "质保")
    private Long guaranteePeriod;

    /** 销售日期 */
    private Date salesDate;

    /** 服务历史记录-&gt;serverStory.id */
    private Long serverStory;

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

    public void setMenufactDate(Date menufactDate) 
    {
        this.menufactDate = menufactDate;
    }

    public Date getMenufactDate() 
    {
        return menufactDate;
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
            .append("menufactDate", getMenufactDate())
            .append("guaranteePeriod", getGuaranteePeriod())
            .append("salesDate", getSalesDate())
            .append("serverStory", getServerStory())
            .toString();
    }
}
