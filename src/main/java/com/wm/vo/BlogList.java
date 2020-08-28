package com.wm.vo;

import com.wm.po.Type;

import java.util.Date;

public class BlogList {

    private Long id;
    private String title;
    private Type type;
    private Long typeId;
    private Boolean recommend;
    private Boolean published;
    private Date updateTime;

    public BlogList() {
    }

    @Override
    public String toString() {
        return "BlogList{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", typeId=" + typeId +
                ", recommend=" + recommend +
                ", published=" + published +
                ", updateTime=" + updateTime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}




