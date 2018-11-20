package com.example.tecl.kotlindemo.bean;

public class HomePageLiveData {
    private String lessonName;
    private String lessonType;
    private int price;
    private int payCount;
    private int queryId;
    private String linkUrl;
    private String img;

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonType(String lessonType) {
        this.lessonType = lessonType;
    }

    public String getLessonType() {
        return lessonType;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPayCount(int payCount) {
        this.payCount = payCount;
    }

    public int getPayCount() {
        return payCount;
    }

    public void setQueryId(int queryId) {
        this.queryId = queryId;
    }

    public int getQueryId() {
        return queryId;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImg() {
        return img;
    }


}
