package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * afterSales对象 AfterSales
 * 
 * @author peng
 * @date 2024-07-04
 */
public class AfterSales extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /**  */
    private Long deviceid;

    /** 下单日期 */
    @Excel(name = "下单日期")
    private String formDate;

    /** 业务员 */
    @Excel(name = "业务员")
    private String salesman;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String customer;

    /** 客户地址 */
    @Excel(name = "客户地址")
    private String customerAddr;

    /** 质保内外0内1外 */
    private String quality;

    /** 客户联系人 */
    private String connection;

    /** 客户联系电话 */
    private String tel;

    /** 问题描述 */
    @Excel(name = "问题描述")
    private String quetion;

    /** 出厂日期 */
    private String productionDate;

    /** 出厂编号 */
    private String productionID;

    /** 工作情况 */
    private String condition;

    /** 设备型号 */
    @Excel(name = "设备型号")
    private String deviceType;

    /** 材质 */
    private String texture;

    /** 面积 */
    private String area;

    /** 数量 */
    private String amount;

    /** 单据类型，1返厂，2外派 */
    private String formType;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifyTime;

    /**
     * 附件，派工单文件
     */
    private String attachment;
    private String remark;


    /////////////////////////////////////////////////
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setDeviceid(Long deviceid) 
    {
        this.deviceid = deviceid;
    }

    public Long getDeviceid() 
    {
        return deviceid;
    }

    public void setFormDate(String formDate) 
    {
        this.formDate = formDate;
    }

    public String getFormDate() 
    {
        return formDate;
    }

    public void setSalesman(String salesman) 
    {
        this.salesman = salesman;
    }

    public String getSalesman() 
    {
        return salesman;
    }

    public void setCustomer(String customer) 
    {
        this.customer = customer;
    }

    public String getCustomer() 
    {
        return customer;
    }

    public void setCustomerAddr(String customerAddr) 
    {
        this.customerAddr = customerAddr;
    }

    public String getCustomerAddr() 
    {
        return customerAddr;
    }

    public void setQuality(String quality) 
    {
        this.quality = quality;
    }

    public String getQuality() 
    {
        return quality;
    }

    public void setConnection(String connection) 
    {
        this.connection = connection;
    }

    public String getConnection() 
    {
        return connection;
    }

    public void setTel(String tel) 
    {
        this.tel = tel;
    }

    public String getTel() 
    {
        return tel;
    }

    public void setQuetion(String quetion) 
    {
        this.quetion = quetion;
    }

    public String getQuetion() 
    {
        return quetion;
    }

    public void setProductionDate(String productionDate) 
    {
        this.productionDate = productionDate;
    }

    public String getProductionDate() 
    {
        return productionDate;
    }

    public void setProductionID(String productionID) 
    {
        this.productionID = productionID;
    }

    public String getProductionID() 
    {
        return productionID;
    }

    public void setCondition(String condition) 
    {
        this.condition = condition;
    }

    public String getCondition() 
    {
        return condition;
    }

    public void setDeviceType(String deviceType) 
    {
        this.deviceType = deviceType;
    }

    public String getDeviceType() 
    {
        return deviceType;
    }

    public void setTexture(String texture) 
    {
        this.texture = texture;
    }

    public String getTexture() 
    {
        return texture;
    }

    public void setArea(String area) 
    {
        this.area = area;
    }

    public String getArea() 
    {
        return area;
    }

    public void setAmount(String amount) 
    {
        this.amount = amount;
    }

    public String getAmount() 
    {
        return amount;
    }

    public void setFormType(String formType) 
    {
        this.formType = formType;
    }

    public String getFormType() 
    {
        return formType;
    }

    public void setModifyTime(Date modifyTime) 
    {
        this.modifyTime = modifyTime;
    }

    public Date getModifyTime() 
    {
        return modifyTime;
    }


    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deviceid", getDeviceid())
            .append("formDate", getFormDate())
            .append("salesman", getSalesman())
            .append("customer", getCustomer())
            .append("customerAddr", getCustomerAddr())
            .append("quality", getQuality())
            .append("connection", getConnection())
            .append("tel", getTel())
            .append("quetion", getQuetion())
            .append("productionDate", getProductionDate())
            .append("productionID", getProductionID())
            .append("condition", getCondition())
            .append("deviceType", getDeviceType())
            .append("texture", getTexture())
            .append("area", getArea())
            .append("amount", getAmount())
            .append("formType", getFormType())
            .append("createTime", getCreateTime())
            .append("modifyTime", getModifyTime())
            .toString();
    }
}
