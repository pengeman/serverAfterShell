package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户访问记录，展现末尾记录对象 uservisit
 * 
 * @author pengweitao
 * @date 2025-01-09
 */
public class Uservisit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /**  */
    @Excel(name = "")
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("usename", getUsename())
            .append("person", getPerson())
            .append("tel", getTel())
            .append("record", getRecord())
            .append("recordtime", getRecordtime())
            .toString();
    }
}
