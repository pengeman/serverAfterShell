package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 购买方档案对象 buyerinfo
 * 
 * @author pengweitao
 * @date 2024-08-23
 */
public class Buyerinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 联系人 */
    @Excel(name = "联系人")
    private String connection;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String telphone;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setConnection(String connection) 
    {
        this.connection = connection;
    }

    public String getConnection() 
    {
        return connection;
    }

    public void setTelphone(String telphone) 
    {
        this.telphone = telphone;
    }

    public String getTelphone() 
    {
        return telphone;
    }

    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("connection", getConnection())
            .append("telphone", getTelphone())
            .append("address", getAddress())
            .toString();
    }
}
