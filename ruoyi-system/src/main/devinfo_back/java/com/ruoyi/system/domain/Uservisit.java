package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 客户分配对象 uservisit
 * 
 * @author pengweitao
 * @date 2025-01-12
 */
public class Uservisit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 用户名称 */
    @Excel(name = "用户名称")
    private String usename;

    /** 联系人 */
    @Excel(name = "联系人")
    private String person;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String tel;

    /** 访问记录 */
    @Excel(name = "访问记录")
    private String record;

    /** 访问时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "访问时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recordtime;

    /** 销售人员 */
    @Excel(name = "销售人员")
    private Long salesman;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setUsename(String usename) 
    {
        this.usename = usename;
    }

    public String getUsename() 
    {
        return usename;
    }

    public void setPerson(String person) 
    {
        this.person = person;
    }

    public String getPerson() 
    {
        return person;
    }

    public void setTel(String tel) 
    {
        this.tel = tel;
    }

    public String getTel() 
    {
        return tel;
    }

    public void setRecord(String record) 
    {
        this.record = record;
    }

    public String getRecord() 
    {
        return record;
    }

    public void setRecordtime(Date recordtime) 
    {
        this.recordtime = recordtime;
    }

    public Date getRecordtime() 
    {
        return recordtime;
    }

    public void setSalesman(Long salesman) 
    {
        this.salesman = salesman;
    }

    public Long getSalesman() 
    {
        return salesman;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("usename", getUsename())
            .append("person", getPerson())
            .append("tel", getTel())
            .append("record", getRecord())
            .append("recordtime", getRecordtime())
            .append("salesman", getSalesman())
            .toString();
    }
}
