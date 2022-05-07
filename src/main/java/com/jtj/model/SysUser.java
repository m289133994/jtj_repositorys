package com.jtj.model;

import java.io.Serializable;
import java.util.Date;

/****
 * @Author: csh
 * @Description:SysUser构建
 *****/
public class SysUser implements Serializable{
	private Integer userId;//主键

	private String name;//用户名

	private String pwd;//密码

	private String corporateIdentify;//企业标识

	private Integer status;//数据状态 0:无效 1：有效

	private Date createTime;//创建时间

	private Date updateTime;//更新时间

	private String remark;//备注



	//get方法
	public Integer getUserId() {
		return userId;
	}

	//set方法
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	//get方法
	public String getName() {
		return name;
	}

	//set方法
	public void setName(String name) {
		this.name = name;
	}
	//get方法
	public String getPwd() {
		return pwd;
	}

	//set方法
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	//get方法
	public String getCorporateIdentify() {
		return corporateIdentify;
	}

	//set方法
	public void setCorporateIdentify(String corporateIdentify) {
		this.corporateIdentify = corporateIdentify;
	}
	//get方法
	public Date getCreateTime() {
		return createTime;
	}

	//set方法
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	//get方法
	public Date getUpdateTime() {
		return updateTime;
	}

	//set方法
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	//get方法
	public String getRemark() {
		return remark;
	}

	//set方法
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getStatus() { return status; }

	public void setStatus(Integer status) { this.status = status; }
}
