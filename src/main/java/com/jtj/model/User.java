package com.jtj.model;


/**
 * @author csh
 * @date 2019/11/17 10:11:56
 * @description
 */
public class User {
    private Integer id;
    private String name;
    private String pwd;
    private String perms;
    //盐值
    private String saltValue;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getPwd() { return pwd; }

    public void setPwd(String pwd) { this.pwd = pwd; }

    public String getPerms() { return perms; }

    public void setPerms(String perms) { this.perms = perms; }

    public String getSaltValue() { return saltValue; }

    public void setSaltValue(String saltValue) { this.saltValue = saltValue; }


}
