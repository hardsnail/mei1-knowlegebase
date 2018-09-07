package com.mei1.knowlegebase.api.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
public class Article extends BaseEntity {

    private static final long serialVersionUID = 2929138592667807372L;

    private String title;

    private Long menuId;

    @Lob
    private String context;

    private Long createUserId;

    private String createUserName;

    private Date createdTime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
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

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

}
