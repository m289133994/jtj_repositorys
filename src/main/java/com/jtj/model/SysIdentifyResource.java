package com.jtj.model;

import java.util.Date;


public class SysIdentifyResource {
    /**
     *   主键
     */
    private Integer id;

    /**
     *   企业标识
     */
    private String corporateIdentify;

    /**
     *   外键，关联resource表
     */
    private Integer resourceId;

    /**
     *   数据状态 1:有效 0：无效
     */
    private Integer status;

    /**
     *   创建时间
     */
    private Date createTime;

    /**
     *   更新时间
     */
    private Date updateTime;

    /**
     *   备注
     */
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorporateIdentify() {
        return corporateIdentify;
    }

    public void setCorporateIdentify(String corporateIdentify) {
        this.corporateIdentify = corporateIdentify;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}