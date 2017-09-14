package com.onclick.angie.courseseeder;

/**
 * Created by Angie on 9/14/2017.
 */

public class CourseInfo {
    String crsId;
    String crsTitle;
    String crsDesc;
    String crsImg;
    String crsVidlink;
    int crsEcount;
    String crsAvail;

    public CourseInfo(){

    }

    public CourseInfo(String crsId, String crsTitle, String crsDesc, String crsImg, String crsVidlink, int crsEcount, String crsAvail) {
        this.crsId = crsId;
        this.crsTitle = crsTitle;
        this.crsDesc = crsDesc;
        this.crsImg = crsImg;
        this.crsVidlink = crsVidlink;
        this.crsEcount = crsEcount;
        this.crsAvail = crsAvail;
    }

    public String getCrsId() {
        return crsId;
    }

    public String getCrsTitle() {
        return crsTitle;
    }

    public String getCrsDesc() {
        return crsDesc;
    }

    public String getCrsImg() {
        return crsImg;
    }

    public String getCrsVidlink() {
        return crsVidlink;
    }

    public int getCrsEcount() {
        return crsEcount;
    }

    public String getCrsAvail() {
        return crsAvail;
    }
}
