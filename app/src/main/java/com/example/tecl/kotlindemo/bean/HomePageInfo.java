package com.example.tecl.kotlindemo.bean;

import java.util.List;

public class HomePageInfo {
    private String oneToOneUrl;
    private String goToClassUrl;
    private String indexBooth;
    private Active active;
    private Reservation reservation;
    private List<HeadLines> headLines;
    private Telephone telephone;
    private List<Banners> banners;

    public void setOneToOneUrl(String oneToOneUrl) {
        this.oneToOneUrl = oneToOneUrl;
    }

    public String getOneToOneUrl() {
        return oneToOneUrl;
    }

    public void setGoToClassUrl(String goToClassUrl) {
        this.goToClassUrl = goToClassUrl;
    }

    public String getGoToClassUrl() {
        return goToClassUrl;
    }

    public void setIndexBooth(String indexBooth) {
        this.indexBooth = indexBooth;
    }

    public String getIndexBooth() {
        return indexBooth;
    }

    public void setActive(Active active) {
        this.active = active;
    }

    public Active getActive() {
        return active;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setHeadLines(List<HeadLines> headLines) {
        this.headLines = headLines;
    }

    public List<HeadLines> getHeadLines() {
        return headLines;
    }

    public void setTelephone(Telephone telephone) {
        this.telephone = telephone;
    }

    public Telephone getTelephone() {
        return telephone;
    }

    public void setBanners(List<Banners> banners) {
        this.banners = banners;
    }

    public List<Banners> getBanners() {
        return banners;
    }

    /**
     * Auto-generated: 2018-11-20 13:37:54
     *
     * @author bejson.com (i@bejson.com)
     * @website http://www.bejson.com/java2pojo/
     */
    public class Banners {

        private String titleDesc;
        private String shareImage;
        private String label;
        private int sort;
        private String title;
        private int tid;
        private String offline;
        private List<String> labelList;
        private String linkImage;
        private String shareTitle;
        private int locationId;
        private String linkUrl;
        private String online;
        private int linkType;
        private String shareUrl;
        private String createOn;
        private int time;
        private String shareDesc;
        public void setTitleDesc(String titleDesc) {
            this.titleDesc = titleDesc;
        }
        public String getTitleDesc() {
            return titleDesc;
        }

        public void setShareImage(String shareImage) {
            this.shareImage = shareImage;
        }
        public String getShareImage() {
            return shareImage;
        }

        public void setLabel(String label) {
            this.label = label;
        }
        public String getLabel() {
            return label;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }
        public int getSort() {
            return sort;
        }

        public void setTitle(String title) {
            this.title = title;
        }
        public String getTitle() {
            return title;
        }

        public void setTid(int tid) {
            this.tid = tid;
        }
        public int getTid() {
            return tid;
        }

        public void setOffline(String offline) {
            this.offline = offline;
        }
        public String getOffline() {
            return offline;
        }

        public void setLabelList(List<String> labelList) {
            this.labelList = labelList;
        }
        public List<String> getLabelList() {
            return labelList;
        }

        public void setLinkImage(String linkImage) {
            this.linkImage = linkImage;
        }
        public String getLinkImage() {
            return linkImage;
        }

        public void setShareTitle(String shareTitle) {
            this.shareTitle = shareTitle;
        }
        public String getShareTitle() {
            return shareTitle;
        }

        public void setLocationId(int locationId) {
            this.locationId = locationId;
        }
        public int getLocationId() {
            return locationId;
        }

        public void setLinkUrl(String linkUrl) {
            this.linkUrl = linkUrl;
        }
        public String getLinkUrl() {
            return linkUrl;
        }

        public void setOnline(String online) {
            this.online = online;
        }
        public String getOnline() {
            return online;
        }

        public void setLinkType(int linkType) {
            this.linkType = linkType;
        }
        public int getLinkType() {
            return linkType;
        }

        public void setShareUrl(String shareUrl) {
            this.shareUrl = shareUrl;
        }
        public String getShareUrl() {
            return shareUrl;
        }

        public void setCreateOn(String createOn) {
            this.createOn = createOn;
        }
        public String getCreateOn() {
            return createOn;
        }

        public void setTime(int time) {
            this.time = time;
        }
        public int getTime() {
            return time;
        }

        public void setShareDesc(String shareDesc) {
            this.shareDesc = shareDesc;
        }
        public String getShareDesc() {
            return shareDesc;
        }
    }

    public class Telephone {

        private CrInfo crInfo;
        private String tel400;
        private CcInfo ccInfo;
        public void setCrInfo(CrInfo crInfo) {
            this.crInfo = crInfo;
        }
        public CrInfo getCrInfo() {
            return crInfo;
        }

        public void setTel400(String tel400) {
            this.tel400 = tel400;
        }
        public String getTel400() {
            return tel400;
        }

        public void setCcInfo(CcInfo ccInfo) {
            this.ccInfo = ccInfo;
        }
        public CcInfo getCcInfo() {
            return ccInfo;
        }
    }


    public class CcInfo {

        private String userMobile;
        private String userRealName;
        public void setUserMobile(String userMobile) {
            this.userMobile = userMobile;
        }
        public String getUserMobile() {
            return userMobile;
        }

        public void setUserRealName(String userRealName) {
            this.userRealName = userRealName;
        }
        public String getUserRealName() {
            return userRealName;
        }
    }

    public class CrInfo {

        private String userMobile;
        private String userRealName;
        public void setUserMobile(String userMobile) {
            this.userMobile = userMobile;
        }
        public String getUserMobile() {
            return userMobile;
        }

        public void setUserRealName(String userRealName) {
            this.userRealName = userRealName;
        }
        public String getUserRealName() {
            return userRealName;
        }
    }

    /**
     * Copyright 2018 bejson.com
     */
    public class Reservation {

        private String reservationUrl;
        private String reservationTid;
        public void setReservationUrl(String reservationUrl) {
            this.reservationUrl = reservationUrl;
        }
        public String getReservationUrl() {
            return reservationUrl;
        }

        public void setReservationTid(String reservationTid) {
            this.reservationTid = reservationTid;
        }
        public String getReservationTid() {
            return reservationTid;
        }
    }

    public class Active {

        private String studentPwd;
        private List<Items> items;
        private int hasLesson;
        private int total;
        public void setStudentPwd(String studentPwd) {
            this.studentPwd = studentPwd;
        }
        public String getStudentPwd() {
            return studentPwd;
        }

        public void setItems(List<Items> items) {
            this.items = items;
        }
        public List<Items> getItems() {
            return items;
        }

        public void setHasLesson(int hasLesson) {
            this.hasLesson = hasLesson;
        }
        public int getHasLesson() {
            return hasLesson;
        }

        public void setTotal(int total) {
            this.total = total;
        }
        public int getTotal() {
            return total;
        }
    }

    public class Items {

        private String titleDesc;
        private String shareImage;
        private String label;
        private int sort;
        private String title;
        private int tid;
        private String offline;
        private List<String> labelList;
        private String linkImage;
        private String shareTitle;
        private int locationId;
        private String linkUrl;
        private String online;
        private int linkType;
        private String shareUrl;
        private String createOn;
        private int time;
        private String shareDesc;
        public void setTitleDesc(String titleDesc) {
            this.titleDesc = titleDesc;
        }
        public String getTitleDesc() {
            return titleDesc;
        }

        public void setShareImage(String shareImage) {
            this.shareImage = shareImage;
        }
        public String getShareImage() {
            return shareImage;
        }

        public void setLabel(String label) {
            this.label = label;
        }
        public String getLabel() {
            return label;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }
        public int getSort() {
            return sort;
        }

        public void setTitle(String title) {
            this.title = title;
        }
        public String getTitle() {
            return title;
        }

        public void setTid(int tid) {
            this.tid = tid;
        }
        public int getTid() {
            return tid;
        }

        public void setOffline(String offline) {
            this.offline = offline;
        }
        public String getOffline() {
            return offline;
        }

        public void setLabelList(List<String> labelList) {
            this.labelList = labelList;
        }
        public List<String> getLabelList() {
            return labelList;
        }

        public void setLinkImage(String linkImage) {
            this.linkImage = linkImage;
        }
        public String getLinkImage() {
            return linkImage;
        }

        public void setShareTitle(String shareTitle) {
            this.shareTitle = shareTitle;
        }
        public String getShareTitle() {
            return shareTitle;
        }

        public void setLocationId(int locationId) {
            this.locationId = locationId;
        }
        public int getLocationId() {
            return locationId;
        }

        public void setLinkUrl(String linkUrl) {
            this.linkUrl = linkUrl;
        }
        public String getLinkUrl() {
            return linkUrl;
        }

        public void setOnline(String online) {
            this.online = online;
        }
        public String getOnline() {
            return online;
        }

        public void setLinkType(int linkType) {
            this.linkType = linkType;
        }
        public int getLinkType() {
            return linkType;
        }

        public void setShareUrl(String shareUrl) {
            this.shareUrl = shareUrl;
        }
        public String getShareUrl() {
            return shareUrl;
        }

        public void setCreateOn(String createOn) {
            this.createOn = createOn;
        }
        public String getCreateOn() {
            return createOn;
        }

        public void setTime(int time) {
            this.time = time;
        }
        public int getTime() {
            return time;
        }

        public void setShareDesc(String shareDesc) {
            this.shareDesc = shareDesc;
        }
        public String getShareDesc() {
            return shareDesc;
        }

    }

    /**
     * @author bejson.com (i@bejson.com)
     * @website http://www.bejson.com/java2pojo/
     */
    public class HeadLines {
        private String titleDesc;
        private String shareImage;
        private String label;
        private int sort;
        private String title;
        private int tid;
        private String offline;
        private String linkImage;
        private String shareTitle;
        private int locationId;
        private String qrcodeLocation;
        private String linkUrl;
        private String online;
        private int linkType;
        private String shareUrl;
        private String createOn;
        private int time;
        private String shareDesc;
        public void setTitleDesc(String titleDesc) {
            this.titleDesc = titleDesc;
        }
        public String getTitleDesc() {
            return titleDesc;
        }

        public void setShareImage(String shareImage) {
            this.shareImage = shareImage;
        }
        public String getShareImage() {
            return shareImage;
        }

        public void setLabel(String label) {
            this.label = label;
        }
        public String getLabel() {
            return label;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }
        public int getSort() {
            return sort;
        }

        public void setTitle(String title) {
            this.title = title;
        }
        public String getTitle() {
            return title;
        }

        public void setTid(int tid) {
            this.tid = tid;
        }
        public int getTid() {
            return tid;
        }

        public void setOffline(String offline) {
            this.offline = offline;
        }
        public String getOffline() {
            return offline;
        }

        public void setLinkImage(String linkImage) {
            this.linkImage = linkImage;
        }
        public String getLinkImage() {
            return linkImage;
        }

        public void setShareTitle(String shareTitle) {
            this.shareTitle = shareTitle;
        }
        public String getShareTitle() {
            return shareTitle;
        }

        public void setLocationId(int locationId) {
            this.locationId = locationId;
        }
        public int getLocationId() {
            return locationId;
        }

        public void setQrcodeLocation(String qrcodeLocation) {
            this.qrcodeLocation = qrcodeLocation;
        }
        public String getQrcodeLocation() {
            return qrcodeLocation;
        }

        public void setLinkUrl(String linkUrl) {
            this.linkUrl = linkUrl;
        }
        public String getLinkUrl() {
            return linkUrl;
        }

        public void setOnline(String online) {
            this.online = online;
        }
        public String getOnline() {
            return online;
        }

        public void setLinkType(int linkType) {
            this.linkType = linkType;
        }
        public int getLinkType() {
            return linkType;
        }

        public void setShareUrl(String shareUrl) {
            this.shareUrl = shareUrl;
        }
        public String getShareUrl() {
            return shareUrl;
        }

        public void setCreateOn(String createOn) {
            this.createOn = createOn;
        }
        public String getCreateOn() {
            return createOn;
        }

        public void setTime(int time) {
            this.time = time;
        }
        public int getTime() {
            return time;
        }

        public void setShareDesc(String shareDesc) {
            this.shareDesc = shareDesc;
        }
        public String getShareDesc() {
            return shareDesc;
        }

    }
}
