package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 板片信息对象 u_plate
 * 
 * @author pengweitao
 * @date 2025-12-16
 */
public class Plate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 板片型号 */
    @Excel(name = "板片型号")
    private String type;

    /** 材质 */
    @Excel(name = "材质")
    private String material;

    /** 板片厚度 */
    @Excel(name = "板片厚度")
    private Long thinkness;

    /** 板片重量 */
    @Excel(name = "板片重量")
    private Long weight;

    /** 板片单价 */
    @Excel(name = "板片单价")
    private Long price;

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

    public void setMaterial(String material) 
    {
        this.material = material;
    }

    public String getMaterial() 
    {
        return material;
    }

    public void setThinkness(Long thinkness) 
    {
        this.thinkness = thinkness;
    }

    public Long getThinkness() 
    {
        return thinkness;
    }

    public void setWeight(Long weight) 
    {
        this.weight = weight;
    }

    public Long getWeight() 
    {
        return weight;
    }

    public void setPrice(Long price) 
    {
        this.price = price;
    }

    public Long getPrice() 
    {
        return price;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("material", getMaterial())
            .append("thinkness", getThinkness())
            .append("weight", getWeight())
            .append("price", getPrice())
            .toString();
    }
}
