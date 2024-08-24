package com.ruoyi.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 鹦鹉财务对象 parrot
 * 
 * @author pengweitao
 * @date 2024-08-23
 */
public class Parrot extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 商品 */
    @Excel(name = "商品")
    private String goods;

    /** 金额 */
    @Excel(name = "金额")
    private BigDecimal money;

    /** 数量 */
    private Long amount;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date thedate;

    /** 一级分类 */
    @Excel(name = "一级分类")
    private String class1;

    /** 二级分类 */
    @Excel(name = "二级分类")
    private String class2;

    /** 备注 */
    @Excel(name = "备注")
    private String comment;

    /** 人员 */
    @Excel(name = "人员")
    private String person;

    /** 账户 */
    private String account;

    /** 商户 */
    private String business;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setGoods(String goods) 
    {
        this.goods = goods;
    }

    public String getGoods() 
    {
        return goods;
    }

    public void setMoney(BigDecimal money) 
    {
        this.money = money;
    }

    public BigDecimal getMoney() 
    {
        return money;
    }

    public void setAmount(Long amount) 
    {
        this.amount = amount;
    }

    public Long getAmount() 
    {
        return amount;
    }

    public void setThedate(Date thedate) 
    {
        this.thedate = thedate;
    }

    public Date getThedate() 
    {
        return thedate;
    }

    public void setClass1(String class1) 
    {
        this.class1 = class1;
    }

    public String getClass1() 
    {
        return class1;
    }

    public void setClass2(String class2) 
    {
        this.class2 = class2;
    }

    public String getClass2() 
    {
        return class2;
    }

    public void setComment(String comment) 
    {
        this.comment = comment;
    }

    public String getComment() 
    {
        return comment;
    }

    public void setPerson(String person) 
    {
        this.person = person;
    }

    public String getPerson() 
    {
        return person;
    }

    public void setAccount(String account) 
    {
        this.account = account;
    }

    public String getAccount() 
    {
        return account;
    }

    public void setBusiness(String business) 
    {
        this.business = business;
    }

    public String getBusiness() 
    {
        return business;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("goods", getGoods())
            .append("money", getMoney())
            .append("amount", getAmount())
            .append("thedate", getThedate())
            .append("class1", getClass1())
            .append("class2", getClass2())
            .append("comment", getComment())
            .append("person", getPerson())
            .append("account", getAccount())
            .append("business", getBusiness())
            .append("createTime", getCreateTime())
            .toString();
    }
}
