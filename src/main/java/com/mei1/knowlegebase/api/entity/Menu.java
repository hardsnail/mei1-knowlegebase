package com.mei1.knowlegebase.api.entity;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Menu extends BaseEntity {

    private static final long serialVersionUID = 5194574831566748206L;

    private String name;

    private Long parentMenuId;

    private Date createdTime;

    private Long createUserId;

    private String createUserName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentMenuId() {
        return parentMenuId;
    }

    public void setParentMenuId(Long parentMenuId) {
        this.parentMenuId = parentMenuId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

}
