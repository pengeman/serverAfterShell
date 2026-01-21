package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备信息明细对象 devinfo2
 * 
 * @author pengweitao
 * @date 2024-08-22
 */
public class Devinfo2 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 序列号 */
    @Excel(name = "序列号")
    private String serialid;

    /** 设备型号 */
    @Excel(name = "设备型号")
    private String devtype;

    /** 计算书编号 */
    @Excel(name = "计算书编号")
    private String calpagecode;

    /** 换热面积 */
    @Excel(name = "换热面积")
    private String area;

    /** 板片，例如133（v133）一共133张板片，其中小角度133张 */
    @Excel(name = "板片，例如133", readConverterExp = "v=133")
    private String plate;

    /** 板片厚度 */
    @Excel(name = "板片厚度")
    private String thinkness;

    /** 板片材质 */
    @Excel(name = "板片材质")
    private String texture;

    /** 密封垫片EPDMNBR */
    @Excel(name = "密封垫片EPDMNBR")
    private String gasket;

    /** 净重 */
    @Excel(name = "净重")
    private String netweight;

    /** 工作重量 */
    @Excel(name = "工作重量")
    private String workweight;

    /** 体积尺寸 */
    @Excel(name = "体积尺寸")
    private String volume;

    /** 角孔直径孔径 */
    @Excel(name = "角孔直径孔径")
    private String diameter;

    /** 角孔材质 */
    @Excel(name = "角孔材质")
    private String diatexture;

    /** 上下导杆尺寸 */
    @Excel(name = "上下导杆尺寸")
    private String rail;

    /** 左右螺栓 */
    @Excel(name = "左右螺栓")
    private String bolt1;

    /** 上下螺栓 */
    @Excel(name = "上下螺栓")
    private String bolt2;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setSerialid(String serialid) 
    {
        this.serialid = serialid;
    }

    public String getSerialid() 
    {
        return serialid;
    }

    public void setDevtype(String devtype) 
    {
        this.devtype = devtype;
    }

    public String getDevtype() 
    {
        return devtype;
    }

    public void setCalpagecode(String calpagecode) 
    {
        this.calpagecode = calpagecode;
    }

    public String getCalpagecode() 
    {
        return calpagecode;
    }

    public void setArea(String area) 
    {
        this.area = area;
    }

    public String getArea() 
    {
        return area;
    }

    public void setPlate(String plate) 
    {
        this.plate = plate;
    }

    public String getPlate() 
    {
        return plate;
    }

    public void setThinkness(String thinkness) 
    {
        this.thinkness = thinkness;
    }

    public String getThinkness() 
    {
        return thinkness;
    }

    public void setTexture(String texture) 
    {
        this.texture = texture;
    }

    public String getTexture() 
    {
        return texture;
    }

    public void setGasket(String gasket) 
    {
        this.gasket = gasket;
    }

    public String getGasket() 
    {
        return gasket;
    }

    public void setNetweight(String netweight) 
    {
        this.netweight = netweight;
    }

    public String getNetweight() 
    {
        return netweight;
    }

    public void setWorkweight(String workweight) 
    {
        this.workweight = workweight;
    }

    public String getWorkweight() 
    {
        return workweight;
    }

    public void setVolume(String volume) 
    {
        this.volume = volume;
    }

    public String getVolume() 
    {
        return volume;
    }

    public void setDiameter(String diameter) 
    {
        this.diameter = diameter;
    }

    public String getDiameter() 
    {
        return diameter;
    }

    public void setDiatexture(String diatexture) 
    {
        this.diatexture = diatexture;
    }

    public String getDiatexture() 
    {
        return diatexture;
    }

    public void setRail(String rail) 
    {
        this.rail = rail;
    }

    public String getRail() 
    {
        return rail;
    }

    public void setBolt1(String bolt1) 
    {
        this.bolt1 = bolt1;
    }

    public String getBolt1() 
    {
        return bolt1;
    }

    public void setBolt2(String bolt2) 
    {
        this.bolt2 = bolt2;
    }

    public String getBolt2() 
    {
        return bolt2;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("serialid", getSerialid())
            .append("devtype", getDevtype())
            .append("calpagecode", getCalpagecode())
            .append("area", getArea())
            .append("plate", getPlate())
            .append("thinkness", getThinkness())
            .append("texture", getTexture())
            .append("gasket", getGasket())
            .append("netweight", getNetweight())
            .append("workweight", getWorkweight())
            .append("volume", getVolume())
            .append("diameter", getDiameter())
            .append("diatexture", getDiatexture())
            .append("rail", getRail())
            .append("bolt1", getBolt1())
            .append("bolt2", getBolt2())
            .toString();
    }
}
