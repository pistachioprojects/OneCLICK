package com.onclick.angie.oneclick_v20;

/**
 * Created by Angie on 9/13/2017.
 */

public class StudentInfo {

    String studId;
    String studFName;
    String studLName;
    String studEmail;
    String studUName;
    String studPass;

    public StudentInfo(){

    }

    public StudentInfo(String studId, String studFName, String studLName, String studEmail, String studUName, String studPass) {
        this.studId = studId;
        this.studFName = studFName;
        this.studLName = studLName;
        this.studEmail = studEmail;
        this.studUName = studUName;
        this.studPass = studPass;
    }

    public String getStudId() {
        return studId;
    }

    public String getStudFName() {
        return studFName;
    }

    public String getStudLName() {
        return studLName;
    }

    public String getStudEmail() {
        return studEmail;
    }

    public String getStudUName() {
        return studUName;
    }

    public String getStudPass() {
        return studPass;
    }

}
