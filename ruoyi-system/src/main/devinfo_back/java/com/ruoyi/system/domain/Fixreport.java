package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 维修分析报告对象 fixreport
 * 
 * @author pengweitao
 * @date 2024-07-28
 */
public class Fixreport extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private Long deviceid;

    /** 投入使用时间 */
    @Excel(name = "投入使用时间")
    private String worktime;

    /** 使用工况 */
    @Excel(name = "使用工况")
    private String workcase;

    /** 故障类型 */
    @Excel(name = "故障类型")
    private String breakdowntype;

    /** 维修描述 */
    private String fixdescription;

    /** 使用配件 */
    private String mountings;

    /** 维修人员 */
    @Excel(name = "维修人员")
    private String person;

    /** 维修天数 */
    private String fixdays;

    /** 维修开始时间 */
    @Excel(name = "维修开始时间")
    private String begindate;

    /** 维修结束时间 */
    private String enddate;

    /** 产生费用 */
    private String cost;

    /** 分析报告附件 */
    private String reportfile;

    /** 派工单附件 */
    private String dispatchfile;

    /** 售后单id，指向售后单备份记录的id */
    private Long afterSalesID;

    /** 业务员 */
    @Excel(name = "业务员")
    private String salesman;

    /** 客户 */
    @Excel(name = "客户")
    private String customer;

    /** 客户地址 */
    @Excel(name = "客户地址")
    private String customerAddr;

    /** 设备问题描述 */
    @Excel(name = "设备问题描述")
    private String quetion;

    /** 设备类型 */
    @Excel(name = "设备类型")
    private String deviceType;

    /** 出厂编号 */
    @Excel(name = "出厂编号")
    private String productionID;

    /** 修改时间 */
    private Date modifyTime;

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

    public void setWorktime(String worktime) 
    {
        this.worktime = worktime;
    }

    public String getWorktime() 
    {
        return worktime;
    }

    public void setWorkcase(String workcase) 
    {
        this.workcase = workcase;
    }

    public String getWorkcase() 
    {
        return workcase;
    }

    public void setBreakdowntype(String breakdowntype) 
    {
        this.breakdowntype = breakdowntype;
    }

    public String getBreakdowntype() 
    {
        return breakdowntype;
    }

    public void setFixdescription(String fixdescription) 
    {
        this.fixdescription = fixdescription;
    }

    public String getFixdescription() 
    {
        return fixdescription;
    }

    public void setMountings(String mountings) 
    {
        this.mountings = mountings;
    }

    public String getMountings() 
    {
        return mountings;
    }

    public void setPerson(String person) 
    {
        this.person = person;
    }

    public String getPerson() 
    {
        return person;
    }

    public void setFixdays(String fixdays) 
    {
        this.fixdays = fixdays;
    }

    public String getFixdays() 
    {
        return fixdays;
    }

    public void setBegindate(String begindate) 
    {
        this.begindate = begindate;
    }

    public String getBegindate() 
    {
        return begindate;
    }

    public void setEnddate(String enddate) 
    {
        this.enddate = enddate;
    }

    public String getEnddate() 
    {
        return enddate;
    }

    public void setCost(String cost) 
    {
        this.cost = cost;
    }

    public String getCost() 
    {
        return cost;
    }

    public void setReportfile(String reportfile) 
    {
        this.reportfile = reportfile;
    }

    public String getReportfile() 
    {
        return reportfile;
    }

    public void setDispatchfile(String dispatchfile) 
    {
        this.dispatchfile = dispatchfile;
    }

    public String getDispatchfile() 
    {
        return dispatchfile;
    }

    public void setAfterSalesID(Long afterSalesID) 
    {
        this.afterSalesID = afterSalesID;
    }

    public Long getAfterSalesID() 
    {
        return afterSalesID;
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

    public void setQuetion(String quetion) 
    {
        this.quetion = quetion;
    }

    public String getQuetion() 
    {
        return quetion;
    }

    public void setDeviceType(String deviceType) 
    {
        this.deviceType = deviceType;
    }

    public String getDeviceType() 
    {
        return deviceType;
    }

    public void setProductionID(String productionID) 
    {
        this.productionID = productionID;
    }

    public String getProductionID() 
    {
        return productionID;
    }

    public void setModifyTime(Date modifyTime) 
    {
        this.modifyTime = modifyTime;
    }

    public Date getModifyTime() 
    {
        return modifyTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deviceid", getDeviceid())
            .append("worktime", getWorktime())
            .append("workcase", getWorkcase())
            .append("breakdowntype", getBreakdowntype())
            .append("fixdescription", getFixdescription())
            .append("mountings", getMountings())
            .append("person", getPerson())
            .append("fixdays", getFixdays())
            .append("begindate", getBegindate())
            .append("enddate", getEnddate())
            .append("cost", getCost())
            .append("reportfile", getReportfile())
            .append("dispatchfile", getDispatchfile())
            .append("afterSalesID", getAfterSalesID())
            .append("salesman", getSalesman())
            .append("customer", getCustomer())
            .append("customerAddr", getCustomerAddr())
            .append("quetion", getQuetion())
            .append("deviceType", getDeviceType())
            .append("productionID", getProductionID())
            .append("createTime", getCreateTime())
            .append("modifyTime", getModifyTime())
            .toString();
    }
}
