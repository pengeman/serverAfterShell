package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 便签记录发展过程对象 note
 * 
 * @author ruoyi
 * @date 2024-08-15
 */
public class Note extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 过程记录 */
    @Excel(name = "过程记录")
    private String note;
    private int afterSalesID;


    public int getAfterSalesID() {
        return afterSalesID;
    }

    public void setAfterSalesID(int afterSalesID) {
        this.afterSalesID = afterSalesID;
    }



    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setNote(String note) 
    {
        this.note = note;
    }

    public String getNote() 
    {
        return note;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("note", getNote())
            .append("createTime", getCreateTime())
            .toString();
    }
}
