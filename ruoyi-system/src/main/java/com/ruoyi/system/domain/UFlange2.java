package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 法兰-JB/T81-94国标对象 u_flange2
 * 
 * @author pengweitao
 * @date 2025-06-28
 */
public class UFlange2 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 型号 */
    @Excel(name = "型号")
    private String type;

    /** 材质 */
    @Excel(name = "材质")
    private String texture;

    /** 规格 */
    @Excel(name = "规格")
    private String class_;

    /** 单价 */
    @Excel(name = "单价")
    private BigDecimal price;

    /** 图片 */
    private String pic;

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

    public void setClass_(String class_) 
    {
        this.class_ = class_;
    }

    public String getClass_() 
    {
        return class_;
    }

    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }

    public void setPic(String pic) 
    {
        this.pic = pic;
    }

    public String getPic() 
    {
        return pic;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("texture", getTexture())
            .append("class_", getClass_())
            .append("price", getPrice())
            .append("pic", getPic())
            .toString();
    }
}
