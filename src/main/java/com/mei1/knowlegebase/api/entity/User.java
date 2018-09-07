package com.mei1.knowlegebase.api.entity;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class User extends BaseEntity {

    private static final long serialVersionUID = 7515230670949900059L;

    private String username;

    private String password;

    private String nickname;

    private Date createdTime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}
