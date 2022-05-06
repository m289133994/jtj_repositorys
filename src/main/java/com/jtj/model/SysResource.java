package com.jtj.model;

import java.io.Serializable;
import java.util.Date;

/****
 * @Author: csh
 * @Description:SysResource构建
 *****/
public class SysResource implements Serializable{

	private Integer resourceId;//主键

	private String resourceName;//菜单名称

	private Integer parentId;//父id

	private String resourceUrl;//前端url

	private Integer status;//数据状态 0:无效 1：有效

	private Date createTime;//创建时间

	private Date updateTime;//修改时间

	private String remark;//备注



	//get方法
	public Integer getResourceId() {
		return resourceId;
	}

	//set方法
	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}
	//get方法
	public String getResourceName() {
		return resourceName;
	}

	//set方法
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	//get方法
	public Integer getParentId() {
		return parentId;
	}

	//set方法
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	//get方法
	public String getResourceUrl() {
		return resourceUrl;
	}

	//set方法
	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
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
