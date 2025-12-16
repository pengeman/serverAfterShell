package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 板片厚度对象 u_thinkness
 * 
 * @author pengweitao
 * {@code @date} 2025-06-28
 */
public class UThinkness extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 板片厚度 */
    @Excel(name = "板片厚度")
    private BigDecimal thinkness;

    /** 简介 */
    @Excel(name = "简介")
    private String about;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setThinkness(BigDecimal thinkness) 
    {
        this.thinkness = thinkness;
    }

    public BigDecimal getThinkness() 
    {
        return thinkness;
    }

    public void setAbout(String about) 
    {
        this.about = about;
    }

    public String getAbout() 
    {
        return about;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("thinkness", getThinkness())
            .append("about", getAbout())
            .toString();
    }
}
