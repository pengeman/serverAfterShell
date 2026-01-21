package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 夹板对象 u_splint
 * 
 * @author pengweitao
 * {@code @date} 2025-06-28
 */
public class USplint extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 类型 */
    @Excel(name = "类型")
    private String type;

    /** 承压 */
    @Excel(name = "承压")
    private Long pressure;

    /** 最少板片数 */
    @Excel(name = "最少板片数")
    private Long classmin;

    /** 最大板片数 */
    @Excel(name = "最大板片数")
    private Long classmax;

    /** 角孔衬套304,316 */
    @Excel(name = "角孔衬套304,316")
    private String lining;

    /** 单价 */
    @Excel(name = "单价")
    private BigDecimal price;

    /**  */
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

    public void setPressure(Long pressure) 
    {
        this.pressure = pressure;
    }

    public Long getPressure() 
    {
        return pressure;
    }

    public void setClassmin(Long classmin) 
    {
        this.classmin = classmin;
    }

    public Long getClassmin() 
    {
        return classmin;
    }

    public void setClassmax(Long classmax) 
    {
        this.classmax = classmax;
    }

    public Long getClassmax() 
    {
        return classmax;
    }

    public void setLining(String lining) 
    {
        this.lining = lining;
    }

    public String getLining() 
    {
        return lining;
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
            .append("pressure", getPressure())
            .append("classmin", getClassmin())
            .append("classmax", getClassmax())
            .append("lining", getLining())
            .append("price", getPrice())
            .append("pic", getPic())
            .toString();
    }
}
