package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备档案对象 devInfo
 * 
 * @author pengweitao
 * @date 2024-08-22
 */
public class DevInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** serial number序列号 */
    @Excel(name = "serial number序列号")
    private String serialid;

    /** 制造日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "制造日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date makedate;

    /** 合同 */
    @Excel(name = "合同")
    private String controct;

    /** 购买方 */
    @Excel(name = "购买方")
    private String buyerid;

    /** 用户id */
    @Excel(name = "用户id")
    private String userid;

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

    public void setBuyerid(String buyerid)
    {
        this.buyerid = buyerid;
    }

    public String getBuyerid()
    {
        return buyerid;
    }

    public void setUserid(String userid)
    {
        this.userid = userid;
    }

    public String getUserid()
    {
        return userid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("serialid", getSerialid())
            .append("makedate", getMakedate())
            .append("controct", getControct())
            .append("buyerid", getBuyerid())
            .append("userid", getUserid())
            .toString();
    }
}
