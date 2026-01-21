package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 接管类型对象 u_pipeline
 * 
 * @author pengweitao
 * {@code @date} 2025-06-28
 */
public class UPipeline extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 板型 */
    @Excel(name = "板型")
    private String type;

    /** 接管材质 */
    @Excel(name = "接管材质")
    private String texture;

    /** 单价 */
    @Excel(name = "单价")
    private BigDecimal price;

    /** 简介 */
    private String about;

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

    public void setTexture(String texture) 
    {
        this.texture = texture;
    }

    public String getTexture() 
    {
        return texture;
    }

    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
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
            .append("type", getType())
            .append("texture", getTexture())
            .append("price", getPrice())
            .append("about", getAbout())
            .toString();
    }
}
