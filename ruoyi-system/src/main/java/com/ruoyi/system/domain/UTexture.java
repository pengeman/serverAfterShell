package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 材质对象 u_texture
 * 
 * @author pengweitao
 * {@code @date} 2025-06-28
 */
public class UTexture extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 材质 */
    @Excel(name = "材质")
    private String texture;

    /** 材质简介 */
    @Excel(name = "材质简介")
    private String about;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setTexture(String texture) 
    {
        this.texture = texture;
    }

    public String getTexture() 
    {
        return texture;
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
            .append("texture", getTexture())
            .append("about", getAbout())
            .toString();
    }
}
