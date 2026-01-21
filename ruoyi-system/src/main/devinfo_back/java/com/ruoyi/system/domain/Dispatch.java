package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 派工单对象 dispatch
 * 
 * @author pengweitao
 * @date 2026-01-20
 */
public class Dispatch extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 客户id */
    private Long clientid;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String clientname;

    /** 地址 */
    private String address;

    /** 联系人 */
    private String connection;

    /** 联系电话 */
    private String telphone;

    /** 设备类型 */
    @Excel(name = "设备类型")
    private Long devType;

    /** 设备材质 */
    private String devTexture;

    /** 设备型号 */
    @Excel(name = "设备型号")
    private String thetype;

    /** 设备编号 */
    private String sn;

    /** 换热面积 */
    @Excel(name = "换热面积")
    private Long area;

    /** 保质期[保内外] */
    private String guaranteePeriod;

    /** 维修类型 */
    private String servicetype;

    /** 出厂日期 */
    private Date makedate;

    /** 数量 */
    @Excel(name = "数量")
    private Long quantity;

    /** 工况热 热测工况,介质温度压力 */
    private String workingCondition1;

    /** 工况冷 冷测工况，介质温度压力 */
    private String workingCondition2;

    /** 所需材料 */
    private String materialsPlan;

    /** 问题内容 */
    private String question;

    /** 维修方案 */
    private String fixPlan;

    /** 维修价格 */
    private Long fixPrice;

    /** 故障诊断 */
    private String diagnose;

    /** 故障处理 */
    private String handling;

    /** 故障原因 */
    private String cause;

    /** 使用材料 */
    private String materials;

    /** 服务结果 */
    private String serviceRelult;

    /** 客户反馈 */
    private String clientComment;

    /** 客户签字 */
    private String clientSign;

    /** 申请人签字 */
    private String requestsign;

    /** 服务人员签字 */
    private String serviceSign;

    /** 服务内容 */
    private String serviceContent;

    /** 开始日期 */
    private Date beginDate;

    /** 结束日期 */
    private Date endDate;

    /** 服务时长 */
    private Long serviceTime;

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    /** 创建人编号 当前用户ID */
    private Long CreatorId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setClientid(Long clientid) 
    {
        this.clientid = clientid;
    }

    public Long getClientid() 
    {
        return clientid;
    }

    public void setClientname(String clientname) 
    {
        this.clientname = clientname;
    }

    public String getClientname() 
    {
        return clientname;
    }

    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }

    public void setConnection(String connection) 
    {
        this.connection = connection;
    }

    public String getConnection() 
    {
        return connection;
    }

    public void setTelphone(String telphone) 
    {
        this.telphone = telphone;
    }

    public String getTelphone() 
    {
        return telphone;
    }

    public void setDevType(Long devType) 
    {
        this.devType = devType;
    }

    public Long getDevType() 
    {
        return devType;
    }

    public void setDevTexture(String devTexture) 
    {
        this.devTexture = devTexture;
    }

    public String getDevTexture() 
    {
        return devTexture;
    }

    public void setThetype(String thetype) 
    {
        this.thetype = thetype;
    }

    public String getThetype() 
    {
        return thetype;
    }

    public void setSn(String sn) 
    {
        this.sn = sn;
    }

    public String getSn() 
    {
        return sn;
    }

    public void setArea(Long area) 
    {
        this.area = area;
    }

    public Long getArea() 
    {
        return area;
    }

    public void setGuaranteePeriod(String guaranteePeriod) 
    {
        this.guaranteePeriod = guaranteePeriod;
    }

    public String getGuaranteePeriod() 
    {
        return guaranteePeriod;
    }

    public void setServicetype(String servicetype) 
    {
        this.servicetype = servicetype;
    }

    public String getServicetype() 
    {
        return servicetype;
    }

    public void setMakedate(Date makedate) 
    {
        this.makedate = makedate;
    }

    public Date getMakedate() 
    {
        return makedate;
    }

    public void setQuantity(Long quantity) 
    {
        this.quantity = quantity;
    }

    public Long getQuantity() 
    {
        return quantity;
    }

    public void setWorkingCondition1(String workingCondition1) 
    {
        this.workingCondition1 = workingCondition1;
    }

    public String getWorkingCondition1() 
    {
        return workingCondition1;
    }

    public void setWorkingCondition2(String workingCondition2) 
    {
        this.workingCondition2 = workingCondition2;
    }

    public String getWorkingCondition2() 
    {
        return workingCondition2;
    }

    public void setMaterialsPlan(String materialsPlan) 
    {
        this.materialsPlan = materialsPlan;
    }

    public String getMaterialsPlan() 
    {
        return materialsPlan;
    }

    public void setQuestion(String question) 
    {
        this.question = question;
    }

    public String getQuestion() 
    {
        return question;
    }

    public void setFixPlan(String fixPlan) 
    {
        this.fixPlan = fixPlan;
    }

    public String getFixPlan() 
    {
        return fixPlan;
    }

    public void setFixPrice(Long fixPrice) 
    {
        this.fixPrice = fixPrice;
    }

    public Long getFixPrice() 
    {
        return fixPrice;
    }

    public void setDiagnose(String diagnose) 
    {
        this.diagnose = diagnose;
    }

    public String getDiagnose() 
    {
        return diagnose;
    }

    public void setHandling(String handling) 
    {
        this.handling = handling;
    }

    public String getHandling() 
    {
        return handling;
    }

    public void setCause(String cause) 
    {
        this.cause = cause;
    }

    public String getCause() 
    {
        return cause;
    }

    public void setMaterials(String materials) 
    {
        this.materials = materials;
    }

    public String getMaterials() 
    {
        return materials;
    }

    public void setServiceRelult(String serviceRelult) 
    {
        this.serviceRelult = serviceRelult;
    }

    public String getServiceRelult() 
    {
        return serviceRelult;
    }

    public void setClientComment(String clientComment) 
    {
        this.clientComment = clientComment;
    }

    public String getClientComment() 
    {
        return clientComment;
    }

    public void setClientSign(String clientSign) 
    {
        this.clientSign = clientSign;
    }

    public String getClientSign() 
    {
        return clientSign;
    }

    public void setRequestsign(String requestsign) 
    {
        this.requestsign = requestsign;
    }

    public String getRequestsign() 
    {
        return requestsign;
    }

    public void setServiceSign(String serviceSign) 
    {
        this.serviceSign = serviceSign;
    }

    public String getServiceSign() 
    {
        return serviceSign;
    }

    public void setServiceContent(String serviceContent) 
    {
        this.serviceContent = serviceContent;
    }

    public String getServiceContent() 
    {
        return serviceContent;
    }

    public void setBeginDate(Date beginDate) 
    {
        this.beginDate = beginDate;
    }

    public Date getBeginDate() 
    {
        return beginDate;
    }

    public void setEndDate(Date endDate) 
    {
        this.endDate = endDate;
    }

    public Date getEndDate() 
    {
        return endDate;
    }

    public void setServiceTime(Long serviceTime) 
    {
        this.serviceTime = serviceTime;
    }

    public Long getServiceTime() 
    {
        return serviceTime;
    }

    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    public void setCreatorId(Long CreatorId) 
    {
        this.CreatorId = CreatorId;
    }

    public Long getCreatorId() 
    {
        return CreatorId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("clientid", getClientid())
            .append("clientname", getClientname())
            .append("address", getAddress())
            .append("connection", getConnection())
            .append("telphone", getTelphone())
            .append("devType", getDevType())
            .append("devTexture", getDevTexture())
            .append("thetype", getThetype())
            .append("sn", getSn())
            .append("area", getArea())
            .append("guaranteePeriod", getGuaranteePeriod())
            .append("servicetype", getServicetype())
            .append("makedate", getMakedate())
            .append("quantity", getQuantity())
            .append("workingCondition1", getWorkingCondition1())
            .append("workingCondition2", getWorkingCondition2())
            .append("materialsPlan", getMaterialsPlan())
            .append("question", getQuestion())
            .append("fixPlan", getFixPlan())
            .append("fixPrice", getFixPrice())
            .append("diagnose", getDiagnose())
            .append("handling", getHandling())
            .append("cause", getCause())
            .append("materials", getMaterials())
            .append("serviceRelult", getServiceRelult())
            .append("clientComment", getClientComment())
            .append("clientSign", getClientSign())
            .append("requestsign", getRequestsign())
            .append("serviceSign", getServiceSign())
            .append("serviceContent", getServiceContent())
            .append("beginDate", getBeginDate())
            .append("endDate", getEndDate())
            .append("serviceTime", getServiceTime())
            .append("status", getStatus())
            .append("CreatorId", getCreatorId())
            .append("CreateTime", getCreateTime())
            .toString();
    }
}
