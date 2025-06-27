package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 单板面积对象 u_area
 * 
 * @author pengweitao
 * @date 2025-06-27
 */
public class UArea extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 板型 */
    @Excel(name = "板型")
    private String type;

    /** 面积 */
    @Excel(name = "面积")
    private Double area;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }

    public void setArea(Double area) 
    {
        this.area = area;
    }

    public Double getArea() 
    {
        return area;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("area", getArea())
            .toString();
    }
}
